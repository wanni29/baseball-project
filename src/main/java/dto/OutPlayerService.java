package dto;

import model.outplayer.OutPlayerDAO;
import model.player.PlayerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OutPlayerService {

    // 소켓 연결
    Connection connection;
    OutPlayerDAO outPlayerDAO;
    PlayerDAO playerDAO;

    public OutPlayerService(Connection connection) {
        this.connection = connection;
        this.outPlayerDAO = new OutPlayerDAO(connection);
        this.playerDAO = new PlayerDAO(connection);

    }


    // 퇴출 선수 등록
    public void addOutPlayer(String requestContent) throws Exception {
        String[] parts = requestContent.split("&");
        String[] parts1 = parts[0].split("=");
        String[] parts2 = parts[1].split("=");

        int playerId = Integer.parseInt(parts1[1]);
        String reason = parts2[1];

        outPlayerDAO.insert(playerId, reason);
        playerDAO.update(null, playerId);

        System.out.println("성공");
    }

    // 퇴출 선수 목록 조회
    public List<OutPlayerRespDTO> outPlayerList() throws Exception {
        List<OutPlayerRespDTO> outPlayerRespDTOS = new ArrayList<>();
        String sql = "SELECT\n" +
                "    o_tb.player_id,\n" +
                "    o_tb.reason,\n" +
                "    o_tb.created_at,\n" +
                "    p_tb.team_id,\n" +
                "    p_tb.name,\n" +
                "    p_tb.position\n" +
                "FROM\n" +
                "    out_player o_tb\n" +
                "    INNER JOIN player p_tb ON p_tb.id = o_tb.player_id";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                OutPlayerRespDTO dto = OutPlayerRespDTO.builder()
                        .teamId(rs.getInt("team_id"))
                        .name(rs.getString("name"))
                        .position(rs.getString("position"))
                        .playerId(rs.getInt("player_id"))
                        .reason(rs.getString("reason"))
                        .createdAt(rs.getTimestamp("created_at"))
                        .build();
                outPlayerRespDTOS.add(dto);
            }
        }
        return outPlayerRespDTOS;
    }
}
package dto;

import model.player.PlayerDAO;
import model.team.TeamDAO;

import java.sql.Connection;
import java.util.List;

public class PlayerService {

    Connection connection;
    PlayerDAO playerDAO;

    TeamDAO teamDAO;

    public PlayerService(Connection connection) {
        this.connection = connection;
        this.playerDAO = new PlayerDAO(connection);
        this.teamDAO = new TeamDAO(connection);
    }


    public void addPlayer(String request) throws Exception {
        String[] parts = request.split("\\?");
        String playerStatus = parts[1];
        String[] partss = playerStatus.split("&");
        String[] partss1 = partss[0].split("=");
        String[] partss2 = partss[1].split("=");
        String[] partss3 = partss[2].split("=");

        int team_id = Integer.parseInt(partss1[1]);
        String name = partss2[1];
        String position = partss3[1];

        playerDAO.insert(team_id, name, position);

        System.out.println("성공");
    }


    public void showMeThePlayer() throws Exception {
        List<PositionRespDto> dtos = teamDAO.pivotStyle(1, 1, 2, 3);
        System.out.println("포지션\t\tLG\t\t\tNC\t\t\tKIA");
        for (PositionRespDto dto : dtos) {
            System.out.println(dto.getPostion() + "  \t\t" + dto.getLG() + "\t\t" + dto.getNC() + "\t\t" + dto.getKIA());

        }


    }
}

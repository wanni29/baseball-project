package dto;

import db.DBConnection;
import model.player.Player;
import model.player.PlayerDAO;
import model.stadium.StadiumDAO;
import model.team.Team;
import model.team.TeamDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TeamService {

    Connection connection;
    TeamDAO teamDAO;
    PlayerDAO playerDAO;

    public TeamService(Connection connection, TeamDAO teamDAO, PlayerDAO playerDAO) {
        this.connection = connection;
        this.teamDAO = teamDAO;
        this.playerDAO = playerDAO;
    }

    //3.3 팀 등록
    //요청 : 팀등록?stadiumId=1&name=NC
    //응답 : 성공이라는 메시지를 출력한다.
    public void TeamRegister(String request)throws Exception{
        String[] parts = request.split("\\?");
        String playerStatus = parts[1];
        String[] partss = playerStatus.split("&");
        String[] partss1 = partss[0].split("=");
        String[] partss2 = partss[1].split("=");
        int stadiumId = Integer.parseInt(partss1[1]);
        String name = partss2[1];
        teamDAO.insert(stadiumId, name);
        System.out.println("성공");
    }

    // 3.4 전체 팀 목록보기
    //요청 : 팀목록
    //응답 : 팀 목록은 Stadium 정보를 조인해서 출력해야 된다. TeamRespDTO가 필요하다.
    public void TeamViewList(String request)throws Exception{
        List<TeamRespDTO> TeamList = teamDAO.findAll();
        TeamList.forEach(teamRespDTO -> {
            System.out.println("번호 : " + teamRespDTO.getId());
            System.out.println("야구장 이름 : " + teamRespDTO.getStadiumName());
            System.out.println("팀 이름 : " + teamRespDTO.getTeamName());
            System.out.println("생성일 : " + teamRespDTO.getReatedAt());
            System.out.println("----------------------------------------------");
        });
    }

    // 3.6 팀별 선수 목록
    // 요청 : 선수목록?teamId=1
    // 응답 : 선수 목록은 Model -> Player를 List에 담아서 출력한다. (team_id는 출력하지 않아도 된다)
//    public void TeamPlayerList(String request)throws Exception{
//        String[] parts = request.split("\\?");
//        String playerStatus = parts[1];
//        String[] partss = playerStatus.split("=");
//        int stadiumId = Integer.parseInt(partss[1]);
//
//        List<Player> playerList = new ArrayList<>(playerDAO.findByTeamId(stadiumId));
//        playerList.forEach(Player -> {
//            System.out.println("선수 이름 : " + Player.getName());
//            System.out.println("포지션 : " + Player.getPosition());
//            System.out.println("생성일 : " + Player.getCreatedAt());
//            System.out.println("----------------------------------------------");
//        });
//        System.out.println("성공");
//    }


//      <서비스를 구현해야 하는 메소드>
//    public List<PositionRespDto> pivotStyle(int anythingTeamId, int teamId1, int teamId2, int teamId3) throws Exception {
//        List<PositionRespDto> dtos = new ArrayList<>();
//        String sql = "SELECT \n" +
//                "  MAX(IF(team_id = ?, p_tb.position, '')) AS position,\n" +
//                "  MAX(IF(team_id = ?, p_tb.name, '')) AS LG,\n" +
//                "  MAX(IF(team_id = ?, p_tb.name, '')) AS NC,\n" +
//                "  MAX(IF(team_id = ?, p_tb.name, '')) AS KIA\n" +
//                "FROM player p_tb\n" +
//                "INNER JOIN team t_tb ON p_tb.team_id = t_tb.id\n" +
//                "GROUP BY p_tb.position";
//
//
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setInt(1, anythingTeamId);
//            statement.setInt(2, teamId1);
//            statement.setInt(3, teamId2);
//            statement.setInt(4, teamId3);
//
//            // 봐봐 윗부분까지는 jvm에서 sql구문을 이용해서 db 접근을 한다음 스캔을 한 상황이
//            // 여기 까지인거야
//            // 이제 밑에 부분에서는 jvm이 자바의 생태계로 다시 돌아와서
//            // 또 다른 일을 하는거야.
//
//            try (ResultSet rs = statement.executeQuery()) {
//                while (rs.next()) {
//                    PositionRespDto positionRespDto = PositionRespDto.builder()
//                            .postion(rs.getString("position"))
//                            .LG(rs.getString("LG"))
//                            .NC(rs.getString("NC"))
//                            .KIA(rs.getString("KIA"))
//                            .build();
//                    dtos.add(positionRespDto);
//                }
//            }
//        }
//        return dtos;
//    }


//    <출력이 되는 부분!>
//    List<PositionRespDto> dtos = teamDAO.pivotStyle(1, 1, 2, 3);
//        System.out.println("포지션\t\tLG\t\t\tNC\t\t\tKIA");
//        for (PositionRespDto dto : dtos) {
//        System.out.println(dto.getPostion() + "  \t\t" + dto.getLG() + "\t\t" + dto.getNC() + "\t\t" + dto.getKIA());
    }

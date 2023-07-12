package dto;

import db.DBConnection;
import model.player.Player;
import model.player.PlayerDAO;
import model.stadium.StadiumDAO;
import model.team.Team;
import model.team.TeamDAO;
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
}
package dto;

import db.DBConnection;
import model.stadium.StadiumDAO;
import model.team.TeamDAO;
import java.sql.SQLException;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TeamService {
    public static void main(String[] args) throws SQLException {
        // 소켓 받아오기
        Connection connection = DBConnection.getInstance();

        // db 접근하기
        TeamDAO teamDAO = new TeamDAO(connection);

        // 팀 등록
        teamDAO.insert(1,"lotte");

        // 전체 팀 목록
        List<TeamRespDTO> TeamList = teamDAO.findAll();
        TeamList.forEach(teamRespDTO -> {
            System.out.println("번호 : " + teamRespDTO.getId());
            System.out.println("야구장 이름 : " + teamRespDTO.getStadiumName());
            System.out.println("팀 이름 : " + teamRespDTO.getTeamName());
            System.out.println("생성일 : " + teamRespDTO.getReatedAt());
            System.out.println("----------------------------------------------");
        });

        // 팀별 선수 목록




//        //3.3 팀 등록
//        public void TeamRegister(){
//
//        }
//
//        // 3.4 전체 팀 목록보기
//        public void TeamViewList(){
//
//        }
//
//        // 3.6 팀별 선수 목록
//        public void TeamPlayerList(){
//
//        }

    }

}

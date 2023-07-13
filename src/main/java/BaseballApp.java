
import db.DBConnection;
import dto.OutPlayerService;
import dto.PlayerService;
import dto.StadiumService;
import dto.TeamService;
import lombok.Getter;
import model.outplayer.OutPlayerDAO;
import model.player.PlayerDAO;
import model.stadium.StadiumDAO;
import model.team.TeamDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

@Getter
public class BaseballApp {
    private static String stadiumRegister = "야구장등록";
    private static String stadiumViewList = "야구장목록";
    private static String teamRegister = "팀등록";
    private static String teamViewList = "팀목록";
    private static String playerRegister = "선수등록";
    private static String playerTeamViewList = "선수목록";
    private static String outPlayerRegister = "퇴출등록";
    private static String outPlayerViewList = "퇴출목록";
    private static String positionPlayerViewList = "포지션별목록";

    public static void main(String[] args) throws Exception {

        Connection connection = DBConnection.getInstance();
        StadiumDAO stadiumDAO = new StadiumDAO(connection);
        StadiumService stadiumService = new StadiumService(connection,stadiumDAO);
        TeamDAO teamDAO = new TeamDAO(connection);
        PlayerDAO playerDAO = new PlayerDAO(connection);
        TeamService teamService = new TeamService(connection,teamDAO,playerDAO);
        PlayerService playerService = new PlayerService(connection);
        OutPlayerDAO outPlayerDAO = new OutPlayerDAO(connection);
        OutPlayerService outPlayerService = new OutPlayerService(connection);


        Scanner sc = new Scanner(System.in);
        System.out.println("---야구장 관리 프로그램---");
        System.out.println("어떤 기능을 요청하시겠습니다?");
        System.out.println("1.야구장 등록");
        System.out.println("2.야구장 목록");
        System.out.println("3.팀 등록");
        System.out.println("4.팀 목록");
        System.out.println("5.선수 등록");
        System.out.println("6.팀별 선수 목록");
        System.out.println("7.선수 퇴출 등록");
        System.out.println("8.퇴출 목록");
        System.out.println("9.포지션별 목록");
        System.out.println("10.프로그램 종료");
        System.out.println("원하는 기능의 번호를 입력하세요 : ");


        String request = sc.next();



        if(request.equals(stadiumViewList)){
            stadiumService.StadiumViewList();
        }else if(request.equals(teamViewList)){
            teamService.TeamViewList();
        }else if(request.equals(outPlayerViewList)){
            outPlayerService.outPlayerList();
        }else{
            String[] requestSplit = request.split("\\?");
            String requestConfirm = requestSplit[0];
            String requestContent = requestSplit[1];

            if(requestConfirm.equals(stadiumRegister)){
                stadiumService.StadiumRegister(requestContent);
            }
            if(requestConfirm.equals(teamRegister)){
                teamService.TeamRegister(requestContent);
            }
            if(requestConfirm.equals(playerTeamViewList)){
                teamService.TeamPlayerList(requestContent);
            }
            if(requestConfirm.equals(playerRegister)){
                playerService.addPlayer(requestContent);
            }
            if(requestConfirm.equals(outPlayerRegister)){
                outPlayerService.addOutPlayer(requestContent);
            }
        }
    }
}

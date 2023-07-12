
import db.DBConnection;
import dto.StadiumService;
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
    public static String StadiumRegister = "야구장등록";

    public static void main(String[] args) throws Exception {

        Connection connection = DBConnection.getInstance();
        StadiumDAO stadiumDAO = new StadiumDAO(connection);
        StadiumService stadiumService = new StadiumService(connection,stadiumDAO);
        TeamDAO teamDAO = new TeamDAO(connection);
        PlayerDAO playerDAO = new PlayerDAO(connection);
        OutPlayerDAO outPlayerDAO = new OutPlayerDAO(connection);

        Scanner sc = new Scanner(System.in);
        System.out.println("어떤 기능을 요청하시겠습니다?");
        String request = sc.next();
        String[] requestSplit = request.split("\\?");
        String requestConfirm = requestSplit[0];
        String requestContent = requestSplit[1];

        if(requestConfirm.equals(StadiumRegister)){
            stadiumService.StadiumRegister(requestContent);
        }
    }
}

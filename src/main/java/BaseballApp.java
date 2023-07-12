import db.DBConnection;
import model.stadium.Stadium;
import model.stadium.StadiumDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class BaseballApp {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.println("어떤 기능을 요청하시겠습니다?");
        String request = sc.next();
        String[] parts = request.split("\\?");
        String playerStatus = parts[0];



    }
}

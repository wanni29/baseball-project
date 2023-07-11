import db.DBConnection;
import model.outplayer.OutPlayer;
import model.outplayer.OutPlayerDAO;
import model.player.Player;
import model.player.PlayerDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseballApp {
    public static void main(String[] args) throws Exception {

        Connection connection = DBConnection.getInstance();

        OutPlayerDAO outPlayerDAO = new OutPlayerDAO(connection);
        PlayerDAO playerDAO = new PlayerDAO(connection);

        List<OutPlayer> dtos = outPlayerDAO.findAll();
        for (OutPlayer dto : dtos) {
            System.out.println("사유가 있는 선수의 번호 : " + dto.getPlayerId());
            System.out.println("해당 사유 : " + dto.getReason());
            System.out.println();
        }

        System.out.println(" ========================================================= ");
        System.out.println();


        OutPlayer outPlayer = outPlayerDAO.findById(10);
        System.out.println("사유가 있는 선수의 번호 : " + outPlayer.getPlayerId());
        System.out.println("해당 사유 : " + outPlayer.getReason());

    }
}


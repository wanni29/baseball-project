import db.DBConnection;
import dto.OutPlayerRespDTO;
import dto.OutPlayerService;
import dto.TeamService;
import model.player.Player;
import model.player.PlayerDAO;
import model.stadium.Stadium;
import model.stadium.StadiumDAO;
import model.team.TeamDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BaseballApp {
    public static void main(String[] args) throws Exception {
        Connection connection = DBConnection.getInstance();

        PlayerDAO playerDAO = new PlayerDAO(connection);
        TeamDAO teamDAO = new TeamDAO(connection);
        TeamService teamService = new TeamService(connection, teamDAO, playerDAO);
        OutPlayerService outPlayerService = new OutPlayerService(connection);

        List<OutPlayerRespDTO> dtos =  outPlayerService.outPlayerList();
        for (OutPlayerRespDTO dto : dtos) {
            System.out.println(dto.getName());
            System.out.println(dto.getTeamId());
            System.out.println(dto.getReason());
            System.out.println(dto.getPlayerId());
        }



    }
}
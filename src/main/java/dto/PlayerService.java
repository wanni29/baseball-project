package dto;

import model.player.PlayerDAO;

import java.sql.Connection;

public class PlayerService {

    Connection connection;
    PlayerDAO playerDAO;

    public PlayerService(Connection connection) {
        this.connection = connection;
        this.playerDAO = new PlayerDAO(connection);
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



}

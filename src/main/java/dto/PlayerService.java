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



    public void addPlayer(String requestContent) throws Exception {
        String[] parts = requestContent.split("&");
        String[] parts1 = parts[0].split("=");
        String[] parts2 = parts[1].split("=");
        String[] parts3 = parts[2].split("=");

        int teamId = Integer.parseInt(parts1[1]);
        String name = parts2[1];
        String position = parts3[1];

        playerDAO.insert(teamId, name, position);

        System.out.println("성공");
    }



}
package model.outplayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OutPlayerDAO {
    // C - create
    // R - read
    // U - upadate
    // D - delete

    private static Connection connection;

    public OutPlayerDAO(Connection connection) {
        this.connection = connection;
    }

    public static void insert(Integer player_id, String reason) throws SQLException {
        String sql = "insert into out_player( player_id, reason, created_at) values(?, ?, now())";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, player_id);
            statement.setString(2, reason);
            statement.executeUpdate();
        }

    }

    public void delete(Integer player_id) throws SQLException {
        String sql = "delete from out_player where player_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, player_id);
            statement.executeUpdate();
        }
    }

    public void update(String reason, Integer player_id) throws SQLException {
        String sql = "update out_player\n" +
                "set reason = ?\n" +
                "where player_id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, reason);
            statement.setInt(2, player_id);
            statement.executeUpdate();
        }
    }

    public List<OutPlayer> findAll() throws SQLException {
        List<OutPlayer> outPlayers = new ArrayList<>();
        String sql = "select * from out_player";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                OutPlayer outPlayer = new OutPlayer(
                        rs.getInt("id"),
                        rs.getInt("player_id"),
                        rs.getString("reason"),
                        rs.getTimestamp("created_at")
                );
                outPlayers.add(outPlayer);
            }
        }
        return outPlayers;
    }

    public OutPlayer findById(Integer player_id) throws SQLException {
        OutPlayer outPlayer = null;
        String sql = "select *\n" +
                "from player;\n" +
                "SELECT\n" +
                "    o_tb.player_id,\n" +
                "    o_tb.reason,\n" +
                "    p_tb.team_id,\n" +
                "    p_tb.name,\n" +
                "    p_tb.position\n" +
                "FROM\n" +
                "    out_player o_tb\n" +
                "    INNER JOIN player p_tb ON p_tb.id = o_tb.player_id;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, player_id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                outPlayer = new OutPlayer(
                        rs.getInt("id"),
                        rs.getInt("player_id"),
                        rs.getString("reason"),
                        rs.getTimestamp("created_at")


                );
            }
        }
        return outPlayer;
    }
}

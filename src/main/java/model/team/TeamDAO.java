package model.team;

import dto.TeamRespDTO;
import model.stadium.Stadium;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {
    // C - create
    // R - read
    // U - upadate
    // D - delete

    private Connection connection;

    public TeamDAO(Connection connection) {
        this.connection = connection;
    }

    // team 추가 (stadiumId, name 입력시 추가)
    public void insert(int stadiumId, String name)throws SQLException {
        String sql = "INSERT INTO team (stadium_id, name, reated_at) VALUES (?, ?, now())";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,stadiumId);
            statement.setString(2,name);
            statement.executeUpdate();
        }
    }

    // team 삭제 (name 입력시 삭제)
    public void delete(String name)throws SQLException{
        String sql = "delete from team where name = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,name);
            statement.executeUpdate();
        }
    }

    // team 수정(id 입력시 name 수정)
    public void update(int id, String name)throws SQLException{
        String sql = "update team set id = ? where name = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.executeUpdate();
        }
    }

    // team 전체 조회
    public List<TeamRespDTO> findAll()throws SQLException{
        List<TeamRespDTO> TeamList = new ArrayList<>();
        String sql = "select\n" +
                "st.id,\n" +
                "st.name,\n" +
                "te.name,\n" +
                "te.reated_at \n" +
                "from stadium st inner join team te\n" +
                "on st.id = te.stadium_id";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                TeamRespDTO dto = TeamRespDTO.builder()
                        .id(rs.getInt("st.id"))
                        .stadiumName(rs.getString("st.name"))
                        .teamName(rs.getString("te.name"))
                        .reatedAt(rs.getTimestamp("te.reated_at"))
                        .build();
                TeamList.add(dto);
            }
        }
        return TeamList;
    }

    // team 상세 조회 (id 입력시 조회)
    public Stadium findById(String name)throws SQLException{
        Stadium team = null;
        String sql = "select * from team where name = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                team = new Stadium(
                        rs.getInt("id"),
                        //rs.getInt("stadium_id"),
                        rs.getString("name"),
                        rs.getTimestamp("reated_at")
                );
            }
        }
        return team;
    }
}

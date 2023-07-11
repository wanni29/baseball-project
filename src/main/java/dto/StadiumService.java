package dto;

import db.DBConnection;
import model.stadium.Stadium;
import model.stadium.StadiumDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StadiumService {

    public static void main(String[] args) throws SQLException {
        // 소켓 받아오기
        Connection connection = DBConnection.getInstance();

        // db 접근하기
        StadiumDAO stadiumDAO = new StadiumDAO(connection);

        // 야구장 등록
        stadiumDAO.insert("lotte");

        // 전체 야구장 목록
        List<Stadium> StadiumList = stadiumDAO.findAll();
        StadiumList.forEach(stadium -> {
            System.out.println("야구장 이름 : " + stadium.getName());
        });


//        // 3.1 야구장 등록
//        public void StadiumRegister(){
//
//        }
//
//        // 3.2 전체 야구장 목록보기
//        public void StadiumViewList(){
//
//        }
    }

}

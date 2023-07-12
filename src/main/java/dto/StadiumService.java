package dto;

import db.DBConnection;
import model.stadium.Stadium;
import model.stadium.StadiumDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StadiumService {

    Connection connection;
    StadiumDAO stadiumDAO;

    public StadiumService(Connection connection, StadiumDAO stadiumDAO) {
        this.connection = connection;
        this.stadiumDAO = stadiumDAO;
    }

    // 3.1 야구장 등록
    //    요청 : 야구장등록?name=잠실야구장
    //    응답 : 성공이라는 메시지를 출력한다.
    public void StadiumRegister(String request)throws Exception{
        String[] parts = request.split("\\?");
        String playerStatus = parts[1];
        String[] partss = playerStatus.split("=");
        String name = partss[1];
        stadiumDAO.insert(name);
        System.out.println("성공");
    }

    // 3.2 전체 야구장 목록보기
    //    요청 : 야구장목록
    //    응답 : 야구장 목록은 Model -> Stadium을 List에 담아서 출력한다.
    public void StadiumViewList(String request)throws Exception{
        List<Stadium> StadiumList = stadiumDAO.findAll();
        StadiumList.forEach(stadium -> {
            System.out.println("야구장 이름 : " + stadium.getName());
        });
    }
}
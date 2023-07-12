package dto;

public class PositionRespDto {

    // 필요한 데이터 각 테이블에서 뽑아 쓰기

    // table 지정
    //데이터를 뽑을려면 어떤 테이블이 필요할까 ?
    //team table team.id
    //player -> player.team_id


//    SELECT
//    MAX(IF(team_id = 1, p_tb.position, '')) AS position,
//    MAX(IF(team_id = 1, p_tb.name, '')) AS LG,
//    MAX(IF(team_id = 2, p_tb.name, '')) AS NC,
//    MAX(IF(team_id = 3, p_tb.name, '')) AS KIA
//    FROM player p_tb
//    INNER JOIN team t_tb ON p_tb.team_id = t_tb.id
//    GROUP BY p_tb.position;

    // Team table 쪽의 데이터 추출할것
    private Integer stadiumId;
    private String name;


    // player table 쪽의 데이터 추출할것
    private Integer teamId;
    private String name;
    private String position;







}

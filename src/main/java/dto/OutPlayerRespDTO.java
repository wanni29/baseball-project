package dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter

public class OutPlayerRespDTO {

    // 화면에 뿌려줄 데이터 모델링
    // 쿼리 문이 먼저야? 데이터가 먼저야?
    // 쿼리 문이 먼저 인거 같아, 쿼리를 짠 이후에 모델링을 들어가는거잖아.
    // player 측에서 뽑아낼 데이터
    private Integer teamId;
    private String name;
    private String position;


    // out_player 측에서 뽑아낼 데이터
    private Integer playerId;
    private String reason;
    private Timestamp createdAt;

    @Builder
    public OutPlayerRespDTO(Integer teamId, String name, String position, Integer playerId, String reason, Timestamp createdAt) {
        this.teamId = teamId;
        this.name = name;
        this.position = position;
        this.playerId = playerId;
        this.reason = reason;
        this.createdAt = createdAt;
    }
}

package model.stadium;

import lombok.*;

import java.sql.Timestamp;

@Getter
public class Stadium {
    // 모델링 자리 입니다 : )
    private Integer id;
    private String name;
    private Timestamp createdAt;

    @Builder
    public Stadium(Integer id, String name, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }
}

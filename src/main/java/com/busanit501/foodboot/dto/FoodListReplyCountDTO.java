package com.busanit501.foodboot.dto;

import lombok.Data;

import java.time.LocalDateTime;

// 화면 목록에, 댓글의 갯수를 나타내기위한 박스
@Data
public class FoodListReplyCountDTO {
    private  Long fno;
    private  String fname;
    private  String fdesc;
    private  String chef;
    private LocalDateTime regDate;

    // 댓글의 갯수
    private Long replyCount;
}

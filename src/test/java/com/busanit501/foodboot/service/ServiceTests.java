package com.busanit501.foodboot.service;

import com.busanit501.foodboot.dto.FoodDTO;
import com.busanit501.foodboot.dto.FoodListReplyCountDTO;
import com.busanit501.foodboot.dto.PageRequestDTO;
import com.busanit501.foodboot.dto.PageResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
public class ServiceTests {
    @Autowired
    private FoodService foodService;

    @Test
    public void testRegisterFood() {
        // 더미 데이터 필요, 임시 DTO 생성.
        FoodDTO foodDTO = FoodDTO.builder()
                .fname("오늘 점심 뭐 먹지?")
                .fdesc("라면 먹어야지")
                .chef("이상용")
                .regDate(LocalDateTime.now())
                .build();

        Long fno = foodService.register(foodDTO);
        log.info("입력한 게시글 번호: " + fno.toString());
    }

    @Test
    public void testSelectOneFood() {
        // 더미 데이터 필요, 임시 DTO 생성.
        Long fno = 99L;
        FoodDTO foodDTO= foodService.readOne(fno);
        log.info("testSelectOneFood , 하나 조회 foodDTO: " + foodDTO.toString());
    }

    @Test
    public void testUpdateFood() {
        // 수정할 더미 데이터 필요,
        FoodDTO foodDTO = FoodDTO.builder()
                .fno(100L)
                .fname("수정한 오늘 점심 뭐 먹지?")
                .fdesc("칼국수 먹을까?")
                .build();
        foodService.update(foodDTO);

    }

    @Test
    public void testDeleteFood() {
        foodService.delete(100L);
    }

    @Test
    public void testSelectAllFood() {
        // 검색할 더미 데이터
        // 준비물 1) PageRequestDTO, 키워드, 페이지, 사이즈 정보가 다 있음.
        PageRequestDTO pageRequestDTO =
                PageRequestDTO.builder()
                        .page(1)
                        .type("nd")
                        .keyword("food")
                        .size(10)
                        .build();

        PageResponseDTO<FoodDTO> list = foodService.list(pageRequestDTO);
        log.info("list: " + list.toString());
    }

    @Test
    @Transactional
    public void testSelectAllFoodWithReplyCount() {
        // 검색할 더미 데이터
        // 준비물 1) PageRequestDTO, 키워드, 페이지, 사이즈 정보가 다 있음.
        PageRequestDTO pageRequestDTO =
                PageRequestDTO.builder()
                        .page(1)
                        .type("ndc")
                        .keyword("9")
                        .size(10)
                        .build();

        PageResponseDTO<FoodListReplyCountDTO> list = foodService.listWithReplyCount(pageRequestDTO);
        log.info("list: " + list.toString());
    }
}

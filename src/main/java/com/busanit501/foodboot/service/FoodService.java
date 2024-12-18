package com.busanit501.foodboot.service;

import com.busanit501.foodboot.dto.FoodDTO;
import com.busanit501.foodboot.dto.FoodListReplyCountDTO;
import com.busanit501.foodboot.dto.PageRequestDTO;
import com.busanit501.foodboot.dto.PageResponseDTO;

public interface FoodService {
    Long register(FoodDTO foodDTO);
    FoodDTO readOne(Long fno);
    void update(FoodDTO foodDTO);
    void delete(Long fno);
    PageResponseDTO<FoodDTO> list(PageRequestDTO pageRequestDTO);
    PageResponseDTO<FoodListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);

}

package com.busanit501.foodboot.service;

import com.busanit501.foodboot.dto.ReplyDTO;

public interface ReplyService {
    Long register(ReplyDTO replyDTO);
    ReplyDTO readOne(Long rno);
    void update(ReplyDTO replyDTO);
    void delete(Long rno);
//    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}

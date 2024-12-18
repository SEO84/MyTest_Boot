package com.busanit501.foodboot.service;

import com.busanit501.foodboot.domain.Food;
import com.busanit501.foodboot.domain.Reply;
import com.busanit501.foodboot.dto.ReplyDTO;
import com.busanit501.foodboot.repository.FoodRepository;
import com.busanit501.foodboot.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    private final FoodRepository foodRepository;

    private final ModelMapper modelMapper;

    @Override
    public Long register(ReplyDTO replyDTO) {
        // 화면에서 받은 데이터 DTO 타입 -> 엔티티 타입으로 변경,
        // replyDTO, bno 값이 존재.
        log.info("Registering new replyDTO: " + replyDTO);
        Reply reply = modelMapper.map(replyDTO, Reply.class);
        Optional<Food> result = foodRepository.findById(replyDTO.getFno());
        Food food = result.orElseThrow();
        reply.changeFood(food);
        log.info("Registering new reply: " + reply);
        Long rno = replyRepository.save(reply).getRno();
        return rno;
    }

    @Override
    public ReplyDTO readOne(Long rno) {
        Optional<Reply> result = replyRepository.findById(rno);
        Reply reply = result.orElseThrow();
        ReplyDTO replyDTO = modelMapper.map(reply, ReplyDTO.class);
        return replyDTO;
    }

    @Override
    public void update(ReplyDTO replyDTO) {
        Optional<Reply> result = replyRepository.findById(replyDTO.getRno());
        Reply reply = result.orElseThrow();
        reply.changeReplyText(replyDTO.getReplyText());
        replyRepository.save(reply);
    }

    @Override
    public void delete(Long rno) {
        replyRepository.deleteById(rno);
    }
}

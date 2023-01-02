package com.example.multiply.service;

import com.example.multiply.domain.ExamDTO;
import com.example.multiply.domain.QueueDTO;
import com.example.multiply.mapper.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class ExamServiceImp implements ExamService{
    @Autowired
    UserMapper userMapper;
    @Autowired
    RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    QueueDTO queueDTO;
    @Override
    public void insertExam(boolean result, ExamDTO examDTO) throws JsonProcessingException {
        if(result) {
            userMapper.insert(examDTO.getName(), examDTO.getNumA(), examDTO.getNumB());
            queueDTO = new QueueDTO(examDTO.getName(), 10);
            String json = objectMapper.writeValueAsString(queueDTO);
            rabbitTemplate.convertAndSend("exchange01", "routingKey01", json);
//            rabbitTemplate.convertAndSend(
//                    "exchange01",
//                    "routingKey01",
//                    queueDTO
//            );
            System.out.println("정답입니다.");
        }else {
            System.out.println("정답이 아닙니다.");
        }
    }

    @Override
    public ExamDTO findExam(String name) {
        return userMapper.findExam(name);
    }
}

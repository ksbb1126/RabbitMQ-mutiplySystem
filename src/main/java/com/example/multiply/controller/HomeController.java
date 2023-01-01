package com.example.multiply.controller;


import com.example.multiply.domain.ExamDTO;
import com.example.multiply.domain.Multiplication;
import com.example.multiply.domain.MultiplicationResultAttempt;
import com.example.multiply.service.ExamService;
import com.example.multiply.service.MultiplicationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
class HomeController {

    @Autowired
    MultiplicationService multiplicationService;

    @Autowired
    ExamService examService;

    @RequestMapping("/t3")
    public Multiplication func02() {
        System.out.println("func02 Call");
        // (3, 4) 문제를 리턴한다.
        return multiplicationService.createRandomMultiplication();
    }

    @RequestMapping("/t4")
    public void func03(
            @RequestBody MultiplicationResultAttempt mra
    ) throws JsonProcessingException {
        System.out.println("test : t4");
        System.out.println(mra.getUser().getAlias());
        System.out.println(mra.getMultiplication().getFactorA());
        System.out.println(mra.getMultiplication().getFactorB());

        ExamDTO examDTO = new ExamDTO();
        examDTO.setName(mra.getUser().getAlias());
        examDTO.setNumA(mra.getMultiplication().getFactorA());
        examDTO.setNumB(mra.getMultiplication().getFactorB());
        // (3, 4) 문제를 리턴한다.
        examService.insertExam(multiplicationService.checkAttempt(mra), examDTO);
        examService.giveExam(examDTO);
    }
}
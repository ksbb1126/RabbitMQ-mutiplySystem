package com.example.multiply.service;

import com.example.multiply.domain.Multiplication;
import com.example.multiply.domain.MultiplicationResultAttempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationServiceImp implements MultiplicationService {

    @Autowired
    RandomGenService rgs;

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = rgs.getGenRandom();
        int factorB = rgs.getGenRandom();

        return new Multiplication(factorA, factorB);
    }

    @Override
    public boolean checkAttempt(MultiplicationResultAttempt mra) {
        System.out.println("채점을 시작합니다. 결과를 리턴합니다.");
        return mra.getResultAttempt() ==
                mra.getMultiplication().getFactorA() *
                        mra.getMultiplication().getFactorB();
    }
}
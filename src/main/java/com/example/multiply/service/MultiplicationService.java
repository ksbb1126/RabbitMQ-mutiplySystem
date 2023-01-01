package com.example.multiply.service;

import com.example.multiply.domain.Multiplication;
import com.example.multiply.domain.MultiplicationResultAttempt;

public interface MultiplicationService {
    Multiplication createRandomMultiplication();

    boolean checkAttempt(MultiplicationResultAttempt mra);
}

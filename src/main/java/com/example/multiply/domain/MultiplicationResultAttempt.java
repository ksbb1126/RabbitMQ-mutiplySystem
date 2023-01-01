package com.example.multiply.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class MultiplicationResultAttempt {
    User user; // 수검자
    Multiplication multiplication; // 문제
    int resultAttempt; // 답안
}
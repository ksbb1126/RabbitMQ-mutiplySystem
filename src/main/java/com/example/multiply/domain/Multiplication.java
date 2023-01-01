package com.example.multiply.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Multiplication {
    final int factorA; // 3
    final int factorB; // 4

    public Multiplication() {
        this(0, 0);
    }
}

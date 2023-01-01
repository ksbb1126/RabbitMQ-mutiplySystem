package com.example.multiply.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class QueueDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int score;
}

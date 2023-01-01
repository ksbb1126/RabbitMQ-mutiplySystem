package com.example.multiply.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomGenServiceImp implements RandomGenService{
    @Override
    public int getGenRandom() {
        return new Random().nextInt(10);
    }
}

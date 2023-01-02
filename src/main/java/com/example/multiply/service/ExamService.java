package com.example.multiply.service;

import com.example.multiply.domain.ExamDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ExamService {
    void insertExam(boolean result, ExamDTO examDTO) throws JsonProcessingException;

    ExamDTO findExam(String name);
}

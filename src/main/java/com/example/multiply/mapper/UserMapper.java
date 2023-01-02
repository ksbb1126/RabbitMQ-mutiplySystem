package com.example.multiply.mapper;

import com.example.multiply.domain.ExamDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user2(name, numA, numB) VALUES(#{name}, #{numA}, #{numB})")
    void insert(@Param("name") String name, @Param("numA") int numA, @Param("numB") int numB);

    @Select("SELECT * FROM user2 WHERE name=#{name}")
    ExamDTO findExam(@Param("name") String name);
}

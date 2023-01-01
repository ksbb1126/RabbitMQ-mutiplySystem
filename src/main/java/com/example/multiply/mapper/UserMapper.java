package com.example.multiply.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user2(name, numA, numB) VALUES(#{name}, #{numA}, #{numB})")
    void insert(@Param("name") String name, @Param("numA") int numA, @Param("numB") int numB);
}

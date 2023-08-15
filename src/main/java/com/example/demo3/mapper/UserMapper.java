package com.example.demo3.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo3.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from User")
    public List<User> findAllUsers();



    public List<User> selectUserById(@Param("openId") String openId);

    public int deleteById(@Param("openId") String openId);
}

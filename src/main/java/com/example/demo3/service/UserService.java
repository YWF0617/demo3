package com.example.demo3.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo3.entity.User;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface UserService {
    public IPage<User> findUser();

    public List<User> findAllUser();

    public List<User> selectUserById(String openId);

    public int insert(User user);

    public int deleteById(String openId);

    public boolean isIdInTable(String openId);

    public int updateById(User user);


}

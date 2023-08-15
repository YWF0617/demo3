package com.example.demo3.serviceImp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo3.entity.User;
import com.example.demo3.mapper.UserMapper;
import com.example.demo3.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImp implements UserService {

    @Resource
    UserMapper userMapper;

    /*
        分页查询 条件查询
     */
    @Override
    public IPage<User> findUser() {
       // return userMapper.findAllUsers();

        Page<User> page = new Page<User>(1,10);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getName,"Andy");
        return userMapper.selectPage(page,queryWrapper);
    }

    @Override
    public List<User> findAllUser() {

        return userMapper.findAllUsers();
    }


    @Override
    public List<User> selectUserById(String openId){
//        User user = userMapper.selectById(openId);
//        List list =  new ArrayList<User>();
//        list.add(user);
//        return list;

        return userMapper.selectUserById(openId);
    }

    @Override
    public int insert (User user){
        return userMapper.insert(user);

    }

    @Override
    public int deleteById(String openId){
        return userMapper.deleteById(openId);
    }
    @Override
    public boolean isIdInTable(String openId){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", openId);

        // 查询数据库
        int count = userMapper.selectCount(queryWrapper);

        // 判断是否存在
        return count > 0;
    }

    public int updateById(User user){
        return userMapper.updateById(user);
    }

    /*TODO 增、删均根据id

     TODO 新增用户 这块和登录功能一起写




     */


}

package com.example.demo3.Controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo3.entity.User;
import com.example.demo3.response.Result;
import com.example.demo3.service.UserService;
import com.example.demo3.mapper.UserMapper;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    @Resource
    UserService userService;


    /*
       查询用户列表 无参数
     */
    @GetMapping("/user/listUser")
    public Result SelectUsers(){
        IPage page  = userService.findUser();
        return Result.success(page);
    }

    // 列出所有用户
    @GetMapping("/user/findAllUser")
    public Result FindAllUser(){
        List<User> userList = userService.findAllUser();
        return Result.success(userList);
    }


    /*
        根据ID查询用户信息  带参数
     */
    @PostMapping("/user/selectUserById")
    public Result SelectUser(@RequestParam("openId") String openId){
        List<User> userList = userService.selectUserById(openId);
        return Result.success(userList);

    }

    // 添加用户
    @PostMapping("/user/addUser")
    public Result AddUser(@RequestBody User user){

        int r=userService.insert(user);
        System.out.println(r);
        return Result.success(user,"添加用户成功");

    }
//    @PostMapping("/user/addUser1")
//    public Result AddUser1(@RequestParam("name") String name, @RequestParam("address") String address){
//        // 主键id自增长
//        User user = new User();
//        user.setName(name);
//        user.setAddress(address);
//        int r=userService.insert(user);
//        System.out.println(r);
//        return Result.success(user,"添加用户成功");
//
//    }


    // 删除用户
    @PostMapping("/user/deleteUserById")
    public Result DeleteUser(@RequestParam("openId") String openId){
        boolean m=userService.isIdInTable(openId);
        if(m){
            int r=userService.deleteById(openId);
            System.out.println(r);
            return Result.success("删除用户成功");
        }
        else{
            return Result.error("要删除的用户id不存在");
        }
//            int r=userService.deleteById(openId);
//            System.out.println(r);
//            return Result.success("删除用户成功");
    }

    @PostMapping("/user/updateUserById")
    public Result UpdateUser(@RequestBody User user){
        boolean m=userService.isIdInTable(user.getOpenId());
        if(m){
            User user1 = new User();
            user1.setOpenId(user.getOpenId());
            if(!StringUtils.isNullOrEmpty(user.getName()))
            {
                user1.setName(user.getName());
            }
            if (!StringUtils.isNullOrEmpty(user.getAddress())) {
                user1.setAddress(user.getAddress());

            }


            int i = userService.updateById(user1);
            System.out.println(i);
            return Result.success(user1,"更新用户成功");
        }
        else{
            return Result.error("要更新的用户id不存在");
        }



    }




}

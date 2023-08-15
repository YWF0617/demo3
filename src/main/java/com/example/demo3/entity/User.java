package com.example.demo3.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Serialization
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /*
       ID，主键
     */
    @TableId(value = "open_id")
    private String openId;

    @TableField(value = "name")
    private String name;

    @TableField(value = "address")
    private String address;
}

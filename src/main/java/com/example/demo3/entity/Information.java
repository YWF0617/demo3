package com.example.demo3.entity;


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
public class Information {

    @TableId(value = "info_id")
    private long InfoId;

    @TableField(value = "url")
    private String url;

    @TableField(value = "title")
    private String title;

    @TableField(value = "brief")
    private String brief;

    @TableField(value = "picture")
    private String picture;

    /*
        公众号文章上传时间
     */
    @TableField(value = "time")
    private String time;



}

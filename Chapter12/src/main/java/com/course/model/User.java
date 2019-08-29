package com.course.model;

import lombok.Data;

@Data
public class User {

    private int id;
    private String userName;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;

    // 用toString方法 自己变成json格式了
    // 有一些工具 也有对象转换的方法
    @Override
    public String toString(){
        return (
                "{id:"+id+","+
                "userName:"+userName+","+
                "password:"+password+","+
                "age:"+age+","+
                "sex:"+sex+","+
                "permission:"+permission+","+
                "isDelete:"+isDelete+"}"
                );
    }
}

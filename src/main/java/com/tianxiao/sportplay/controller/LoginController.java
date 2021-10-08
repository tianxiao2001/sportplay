package com.tianxiao.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.tianxiao.sportplay.dao.UserDao;
import com.tianxiao.sportplay.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public String login(@RequestBody User user){
        String flag="error";
        User userByMessage = userDao.getUserByMessage(user.getUsername(), user.getPassword());
        System.out.println("user"+userByMessage);
        HashMap<String, Object> res = new HashMap<>();
        if(userByMessage!=null){
            flag="ok";
        }
        res.put("flag", flag);
        res.put("user", user);
        String res_json = JSON.toJSONString(res);
        return res_json;
    }
}

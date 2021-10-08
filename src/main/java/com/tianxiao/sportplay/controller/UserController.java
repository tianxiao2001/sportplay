package com.tianxiao.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.tianxiao.sportplay.dao.UserDao;
import com.tianxiao.sportplay.entity.QueryInfo;
import com.tianxiao.sportplay.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;
    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        //获取最大列表数和当前编号
        int userCounts = userDao.getUserCounts("%" + queryInfo.getQuery() + "%");//获取数据总数
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<User> allUser = userDao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",userCounts);
        res.put("data", allUser);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }
    @RequestMapping("/userstate")
    public String updateUserState(@RequestParam("id")int id,@RequestParam("state")Boolean state) {
        int i = userDao.updateState(id, state);
        return i>0? "success":"error";
    }
    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
      user.setRole("普通用户");
      user.setState(false);
        int i = userDao.addUser(user);
        return i>0? "success":"error";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        int i = userDao.deleteUser(id);
        return i>0 ? "success":"error";
    }
    @RequestMapping("/getUpdateUser")
    public String getUpdateUser(int id){
        User updateUser = userDao.getUpdateUser(id);
        String string = JSON.toJSONString(updateUser);
        return string;
    }
    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user){
        int i = userDao.editUser(user);
        System.out.println(i);
        return i>0 ? "success":"error";
    }
}

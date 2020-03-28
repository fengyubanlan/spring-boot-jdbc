package com.boot.jdbc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author yangjie
 * @classname UserController
 * @date 2020/03/28 0028 17:12:07
 * @description
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/getUser")
    private Object getUser(@RequestParam Integer id){
        if(id==null){
            return null;
        }
        List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from t_user where id="+id);
        if(list!=null && list.size()>0){
            logger.info("list:{}",list.toString());
            return list.get(0);
        }else{
            return null;
        }
    }
}

package com.example.developia.controllers;


import dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("customers")
public class UserController {

    private List<Map<String,String>> list = new ArrayList<Map<String, String>>(){{
        add(new HashMap<String, String>(){{put("id", "1"); put("name", "Bob");}});
    }};
    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping
    public List<Map<String,String>> list(){
        CustomerDao customerDao = applicationContext.getBean("Dao", CustomerDao.class);
        List<Map<String,String>> customerList = customerDao.getAllCustomers();
        return customerList;
    }


}

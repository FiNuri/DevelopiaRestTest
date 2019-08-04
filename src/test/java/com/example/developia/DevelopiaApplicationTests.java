package com.example.developia;

import com.example.developia.model.Сustomer;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import dao.ConnectionPool;
import dao.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DevelopiaApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void daotest(){
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/resttest");
//        config.setUsername("root");
//        config.setPassword("f05121992");
//        HikariDataSource dataSource = new HikariDataSource(config);
//        ConnectionPool pool = new ConnectionPool(dataSource);
//        CustomerDao customerDao = new CustomerDao(pool);
//        List<Map<String,String>> list = customerDao.getAllCustomers();
//
//

    }

}

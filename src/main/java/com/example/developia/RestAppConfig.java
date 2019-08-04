package com.example.developia;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import dao.CustomerDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class RestAppConfig {

    @Value("${DbUrl}")
    private String url;
    @Value("${DbUserName}")
    private String userName;
    @Value("${DbPassword}")
    private String password;

    @Bean("config")
    public HikariConfig config(){

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(userName);
        config.setPassword(password);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );

        return config;
    }

    @Bean("hikariDataSource")
    @DependsOn({"config"})
    public HikariDataSource hikariDataSource(){

        HikariDataSource dataSource = new HikariDataSource(config());
        return dataSource;
    }

    @Bean("Dao")
    @DependsOn({"config","hikariDataSource"})
    public CustomerDao Dao(){
        CustomerDao customerDao = new CustomerDao(hikariDataSource());
        return customerDao;
    }
}

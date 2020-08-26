package com.fwtai.config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * 数据源配置
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2017-11-28 15:04
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
@SpringBootConfiguration
public class DBConfig{

    @Autowired
    private Environment env; /**从配置里获取*/

    /**数据库连接池配置*/
    @Bean
   public DataSource getDataSource(){
        final HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        ds.setJdbcUrl((env.getProperty("spring.datasource.url")));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        return ds;
    }
}
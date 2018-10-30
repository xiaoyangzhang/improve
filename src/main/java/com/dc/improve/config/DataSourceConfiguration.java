package com.dc.improve.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by xiahui on 2018/3/14.
 */

/***
 *
 * DataSource 配置
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

    @Primary
    @Bean(name = "dataSourceMaster")
    @ConfigurationProperties("druid.master")
    public DataSource dataSourceMaster() {

        return DruidDataSourceBuilder.create().build();
    }

}


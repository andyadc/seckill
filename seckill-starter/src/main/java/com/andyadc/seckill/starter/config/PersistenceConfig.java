package com.andyadc.seckill.starter.config;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(value = {"com.andyadc.seckill"})
@MapperScan(value = {"com.andyadc.seckill.infrastructure.mapper"})
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class PersistenceConfig {

    @Bean
    public TransactionManager transactionManager(HikariDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}

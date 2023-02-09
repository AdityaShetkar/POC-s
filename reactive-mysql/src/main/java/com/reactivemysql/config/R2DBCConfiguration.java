package com.reactivemysql.config;

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import dev.miku.r2dbc.mysql.MySqlConnectionFactoryProvider;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class R2DBCConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() {
        MySqlConnectionFactory mySqlConnectionFactory = new MySqlConnectionFactoryProvider(MySqlConnectionConfiguration.builder(host("localhost")
                .port(3306)
                .database("mydb")
                .username("myuser")
                .password("mypassword")
                .build());
        return mySqlConnectionFactory;


    }
}
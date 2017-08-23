package com.mobiquityinc.contextconfig;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Created by anandkhatri on 7/15/15.
 */

@Configuration
@PropertySource("classpath:application.properties")
public class DSContextConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.maxPoolSize}")
    private Integer maxPoolsize;

    @Value("${jdbc.minPoolSize}")
    private Integer minPoolSize;

    @Value("${jdbc.maxStatements}")
    private Integer maxStatements;

    @Value("${jdbc.testConnection}")
    private Boolean testConnection;

    @Bean
    public DataSource dataSource(){
            HikariConfig config = new HikariConfig();
            config.setDriverClassName(driverClassName);
            config.setJdbcUrl(jdbcUrl);
            config.setUsername(username);
            config.setPassword(password);
            config.setMaximumPoolSize(maxPoolsize);
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

            HikariDataSource dataSource = new HikariDataSource(config);
            return dataSource;
    }
}



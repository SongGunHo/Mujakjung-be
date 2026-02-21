package org.koreait.config;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
@MapperScan("org.koreait.mapper")
public class DbConfig {

    @Bean
    public DataSource  dataSource (Environment env) {
        HikariConfig cfg = new HikariConfig();
        cfg.setDriverClassName(env.getProperty("db.driver"));
        cfg.setJdbcUrl(env.getProperty("db.url"));
        cfg.setUsername(env.getProperty("db.username"));
        cfg.setPassword(env.getProperty("db.password"));
        return new HikariDataSource(cfg);
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}

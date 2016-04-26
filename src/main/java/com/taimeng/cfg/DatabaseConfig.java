package com.taimeng.cfg;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringBoot 的配置类
 * @author gaoyong
 *
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
 
    private final Logger logger = Logger.getLogger(DatabaseConfig.class);
 
    /**
     * mybatis连接数据库的配置，不过api项目暂时没有用到mybatis
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.primary")
    public DataSource dataSource() {
    	logger.debug("Configuring Datasource");
    	org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
    	
//    	ds.setTestWhileIdle(true);
//    	ds.setValidationQuery("SELECT 1");
////    	ds.setTimeBetweenEvictionRunsMillis(3600000);//one hour
//    	ds.setTimeBetweenEvictionRunsMillis(3600000);//one hour
//    	ds.setTestOnBorrow(true);
//    	ds.setMinEvictableIdleTimeMillis(18000000);// five hour
//    	ds.setMinEvictableIdleTimeMillis(18000000);// five hour
        return ds;
    }
 
    @Bean(name = "transactionManager")
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
 
}

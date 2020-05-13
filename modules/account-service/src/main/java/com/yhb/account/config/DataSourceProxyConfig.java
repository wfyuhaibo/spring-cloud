package com.yhb.account.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import io.seata.rm.datasource.DataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 使用seata对数据源进行代理
 */
@Slf4j
@Configuration
public class DataSourceProxyConfig {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${druid.max-active}")
    private int maxActive;

    @Value("${druid.initial-size}")
    private int initialSize;

    @Value("${druid.min-idle}")
    private int minIdle;

    @Value("${druid.max-wait}")
    private int maxWait;

    @Value("${druid.time-between-eviction-runs-millis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${druid.min-evictable-idle-time-millis}")
    private int minEvictableIdleTimeMillis;

    @Value("${druid.test-while-idle}")
    private boolean testWhileIdle;

    @Value("${druid.test-on-borrow}")
    private boolean testOnBorrow;

    @Value("${druid.test-on-return}")
    private boolean testOnReturn;

    @Value("${druid.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${druid.maxOpenPreparedStatements}")
    private int maxOpenPreparedStatements;

    @Value("${druid.useGlobalDataSourceStat}")
    private boolean useGlobalDataSourceStat;

    @Value("${mybatis-plus.mapper-locations}")
    private String mapperLocations;

    @Bean
    @Primary // 在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(url);
        datasource.setUsername(username);
        //这里可以做加密处理
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
        datasource.setMaxActive(maxActive);
        datasource.setInitialSize(initialSize);
        datasource.setMaxWait(maxWait);
        datasource.setMinIdle(minIdle);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery("select 'x'");
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        datasource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
        try {
            datasource.setFilters("stat,wall,slf4j");
        } catch (SQLException e) {
            log.error("druid configuration initialization filter", e);
        }
        return new DataSourceProxy(datasource);
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        //设置ip白名单
//        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
//        //设置ip黑名单，优先级高于白名单
//        servletRegistrationBean.addInitParameter("deny", "192.168.0.19");
//        //设置控制台管理用户
//        servletRegistrationBean.addInitParameter("loginUsername", "root");
//        servletRegistrationBean.addInitParameter("loginPassword", "root");
//        //是否可以重置数据
//        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter() {
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}

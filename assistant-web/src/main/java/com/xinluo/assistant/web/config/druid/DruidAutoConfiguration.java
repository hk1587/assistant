package com.xinluo.assistant.web.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Druid数据库连接池
 */
@Configuration
public class DruidAutoConfiguration {
	private Logger logger = LoggerFactory.getLogger(DruidAutoConfiguration.class);

	@Autowired
	private DruidProperties properties;

	/**
	 * DataSource
	 * 
	 * @return
	 */
	@Bean
	@Primary
	public DataSource dataSource() {
		DruidDataSource datasource = new DruidDataSource();

		datasource.setUrl(properties.getUrl());
		datasource.setUsername(properties.getUsername());
		datasource.setPassword(properties.getPassword());
		datasource.setDriverClassName(properties.getDriverClassName());

		datasource.setInitialSize(properties.getInitialSize());
		datasource.setMinIdle(properties.getMinIdle());
		datasource.setMaxActive(properties.getMaxActive());
		datasource.setMaxWait(properties.getMaxWait());
		datasource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
		datasource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
		datasource.setValidationQuery(properties.getValidationQuery());
		datasource.setTestWhileIdle(properties.isTestWhileIdle());
		datasource.setTestOnBorrow(properties.isTestOnBorrow());
		datasource.setTestOnReturn(properties.isTestOnReturn());
		datasource.setUseGlobalDataSourceStat(properties.isUseGlobalDataSourceStat());
		datasource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
		datasource.setKeepAlive(properties.isKeepAlive());
		datasource.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());
		try {
			datasource.setFilters(properties.getFilters());
		} catch (SQLException e) {
			logger.error("druid configuration initialization filter", e);
		}
		datasource.setConnectionProperties(properties.getConnectionProperties());

		return datasource;
	}

	/**
	 * ServletRegistrationBean
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new StatViewServlet());
		servletRegistrationBean.addUrlMappings("/druid/*");

		return servletRegistrationBean;
	}

	/**
	 * FilterRegistrationBean
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean druidWebStatFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		filterRegistrationBean.addInitParameter("sessionStatEnable", "true");
		filterRegistrationBean.addInitParameter("principalSessionName", "org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY");
		return filterRegistrationBean;
	}
}

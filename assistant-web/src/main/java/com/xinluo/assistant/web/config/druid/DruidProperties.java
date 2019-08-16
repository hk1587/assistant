package com.xinluo.assistant.web.config.druid;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Druid数据库连接池 Properties
 */
@Component
@Data
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidProperties {

	private String url;

	private String username;

	private String password;

	private String driverClassName;

	private int initialSize;

	private int minIdle;

	private int maxActive;

	private int maxWait;

	private int timeBetweenEvictionRunsMillis;

	private int minEvictableIdleTimeMillis;

	private String validationQuery;

	private boolean testWhileIdle;

	private boolean testOnBorrow;

	private boolean testOnReturn;

	private boolean poolPreparedStatements;

	private int maxPoolPreparedStatementPerConnectionSize;

	private String filters;

	private String connectionProperties;

	private boolean useGlobalDataSourceStat;

	private boolean keepAlive;

}

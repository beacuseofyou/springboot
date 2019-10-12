package com.hzydbs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="resttemplate")
public class RestTemplateProperties {
	
	private Integer maxTotal;	//总连接数
    private Integer defaultMaxPerRoute; //单个路由最大连接数
    private Integer connectTimeout;		//建立连接超时时间
    private Integer connectionRequestTimeout;	//获取连接超时时间
    private Integer socketTimeout;	//读超时时间
    private Integer validateAfterInactivity;		
    
	public Integer getMaxTotal() {
		return maxTotal;
	}
	public void setMaxTotal(Integer maxTotal) {
		this.maxTotal = maxTotal;
	}
	public Integer getDefaultMaxPerRoute() {
		return defaultMaxPerRoute;
	}
	public void setDefaultMaxPerRoute(Integer defaultMaxPerRoute) {
		this.defaultMaxPerRoute = defaultMaxPerRoute;
	}
	public Integer getConnectTimeout() {
		return connectTimeout;
	}
	public void setConnectTimeout(Integer connectTimeout) {
		this.connectTimeout = connectTimeout;
	}
	public Integer getConnectionRequestTimeout() {
		return connectionRequestTimeout;
	}
	public void setConnectionRequestTimeout(Integer connectionRequestTimeout) {
		this.connectionRequestTimeout = connectionRequestTimeout;
	}
	public Integer getSocketTimeout() {
		return socketTimeout;
	}
	public void setSocketTimeout(Integer socketTimeout) {
		this.socketTimeout = socketTimeout;
	}
	public Integer getValidateAfterInactivity() {
		return validateAfterInactivity;
	}
	public void setValidateAfterInactivity(Integer validateAfterInactivity) {
		this.validateAfterInactivity = validateAfterInactivity;
	}
    
}

package com.config;

import com.filters.HeFilter;
import com.servlets.HeServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author:San Jinhong
 * @create:2018-08-31 10:37:36
 * springboot没有xml,@Configuration可以表示一个spring的xml的配置文件
 * 比如：applicationContext.xml
 **/
@Configuration
public class WebConfig {

    /**
     * 在配置文件中加入spring.http.encoding.enabled=false才生效
     *
     * 依然出现了乱码？
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");
        registration.setFilter(characterEncodingFilter);
        registration.addUrlPatterns("/*");
        System.out.println(characterEncodingFilter.getEncoding());
        return registration;
    }

    /**
     * <bean id="heServletRegistrationBean" ,class="org.springframework.boot.web.servlet.ServletRegistrationBean"/>
     */
    @Bean
    public ServletRegistrationBean heServletRegistrationBean(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new HeServlet(), "/heServlet");
        return registration;
    }

    @Bean
    public FilterRegistrationBean heFilterRegisrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean(new HeFilter());
        return registration;
    }


}

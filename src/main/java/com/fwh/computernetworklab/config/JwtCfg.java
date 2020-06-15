package com.fwh.computernetworklab.config;

import com.fwh.computernetworklab.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 基本JWT过滤器，含有Token的请求可以通过过滤
 */
@Configuration
public class JwtCfg {

    @Bean
    public FilterRegistrationBean jwtFilter() {
//        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/microService/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
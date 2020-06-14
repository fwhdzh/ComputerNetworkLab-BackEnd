package com.fwh.computernetworklab.config;

import com.fwh.computernetworklab.filter.JwtFilter;
import com.fwh.computernetworklab.filter.RoleFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 权限JWT过滤器
 * 有ADMIN权限的Token的请求可以通过过滤
 */
@Configuration
public class RoleCfg {

    @Bean
    public FilterRegistrationBean roleFilter() {
//        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new RoleFilter());
        registrationBean.addUrlPatterns("/microService/populationService");
        registrationBean.addUrlPatterns("/microService/DDosAttackService");
        registrationBean.addUrlPatterns("/microService/SkyNetService");
        registrationBean.setOrder(2);
        return registrationBean;
    }
}

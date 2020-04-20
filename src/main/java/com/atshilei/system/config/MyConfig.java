package com.atshilei.system.config;

import com.atshilei.system.compent.LoginHandlerInterCeptor;
import com.atshilei.system.compent.MyLocaleResolver;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class MyConfig implements WebMvcConfigurer {

    @Override
    //视图映射器
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/hello请求来到view
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/index.html").setViewName("login");


    }

//    @Override
//    //注册拦截器
//    public void addInterceptors(InterceptorRegistry registry) {
//        //addPathPatterns拦截路径
//        //excludePathPatterns不拦截路径
//        registry.addInterceptor(new LoginHandlerInterCeptor()).addPathPatterns("/**")
//                .excludePathPatterns("index.html", "/", "/user/login");
//    }

   //国际化
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}

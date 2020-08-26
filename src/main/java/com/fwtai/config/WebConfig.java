package com.fwtai.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * 配置拦截器|Tomcat服务器配置|路由配置|请求的后缀名
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2018年1月9日 15:27:18
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
@SpringBootConfiguration
public class WebConfig implements WebMvcConfigurer{

    /**设置请求路径及jsp页面路径*/
    @Override
    public void addViewControllers(final ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");//解释:请求路径:/login;返回响应的jsp页面路径:/WEB-INF/view/login.jsp,注意必须在拦截器或配置让其可以访问或放行!
        registry.addViewController("/").setViewName("index");//默认显示的jsp页面是/WEB-INF/view/index.jsp,如果配置了resources/index.html或static/index.html都会走这个html页面,配置的优先权大于默认值,默认是resources/index.html或static/index.html
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter(){
        final StringHttpMessageConverter converter = new StringHttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(new MediaType("text","plain",Charset.forName("UTF-8"))));
        return converter;
    }
}
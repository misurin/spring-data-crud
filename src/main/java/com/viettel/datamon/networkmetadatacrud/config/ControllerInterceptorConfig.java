package com.viettel.datamon.networkmetadatacrud.config;

import com.viettel.datamon.networkmetadatacrud.interceptor.AsyncHandlerInterceptor;
import com.viettel.datamon.networkmetadatacrud.interceptor.ResponseTimeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ControllerInterceptorConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //apply to all http requests
    registry.addInterceptor(new ResponseTimeInterceptor());
    registry.addInterceptor(new AsyncHandlerInterceptor());
  }

}

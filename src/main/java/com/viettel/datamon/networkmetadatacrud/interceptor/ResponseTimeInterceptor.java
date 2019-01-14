package com.viettel.datamon.networkmetadatacrud.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ResponseTimeInterceptor extends HandlerInterceptorAdapter {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResponseTimeInterceptor.class);


  //before the actual handler will be executed
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {
    long startTime = System.currentTimeMillis();
    request.setAttribute("start-time", startTime);
    LOGGER.debug("Start intercepting request {}", request.getRequestURL());
    return true;
  }

  //after the handler is executed
  public void postHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) {
    long stopTime = System.currentTimeMillis();
    long startTime = (long) request.getAttribute("start-time");
    LOGGER.debug("Request {} from {} took {} ms", request.getRequestURL(), request.getRemoteAddr(),
        (stopTime - startTime));
  }
}

package com.viettel.datamon.networkmetadatacrud.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AsyncHandlerInterceptor extends HandlerInterceptorAdapter {

  private static final Logger LOGGER = LoggerFactory.getLogger(AsyncHandlerInterceptor.class);
    @Override
    public boolean preHandle (HttpServletRequest request,
        HttpServletResponse response,
        Object handler) throws Exception {

      LOGGER.info("interceptor#preHandle called. Thread: " + Thread
          .currentThread().getName());
      return true;

    }

    @Override
    public void postHandle (HttpServletRequest request,
        HttpServletResponse response,
        Object handler,
        ModelAndView modelAndView) throws Exception {

      LOGGER.info("interceptor#postHandle called. Thread: " +
          Thread.currentThread()
              .getName());
    }

    @Override
    public void afterCompletion (HttpServletRequest request,
        HttpServletResponse response,
        Object handler, Exception ex) throws Exception {

      LOGGER.info("interceptor#afterCompletion called Thread.: " +
          Thread.currentThread()
              .getName());
    }

    @Override
    public void afterConcurrentHandlingStarted (HttpServletRequest request,
        HttpServletResponse response,
        Object handler) throws Exception {

      LOGGER.info("interceptor#afterConcurrentHandlingStarted. " +
          "Thread: " +
          Thread.currentThread()
              .getName());
    }

}

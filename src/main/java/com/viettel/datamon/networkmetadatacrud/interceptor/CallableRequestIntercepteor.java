package com.viettel.datamon.networkmetadatacrud.interceptor;

import java.util.concurrent.Callable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;

public class CallableRequestIntercepteor implements CallableProcessingInterceptor {

  @Override
  public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {
    return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
  }
}

package com.viettel.datamon.networkmetadatacrud.entity;

import java.util.concurrent.Callable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class TimeoutCallableResponse implements Callable<ResponseEntity> {
  private static final Logger LOGGER = LoggerFactory.getLogger(TimeoutCallableResponse.class);

  @Override
  public ResponseEntity call() {
    ResponseEntity body = new ResponseEntity("Server is busy", HttpStatus.SERVICE_UNAVAILABLE);
    LOGGER.warn("Timeout callable executed, returning message {}",body.toString());
    return body;
  }
}

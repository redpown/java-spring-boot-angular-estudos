package com.springboot.angular.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.angular.controller.exception.handler.Handler;
import com.springboot.angular.service.exception.ObjectNotFound;

@ControllerAdvice
public class ControllerException {
	
	  @ExceptionHandler(ObjectNotFound.class)
	  public ResponseEntity<Handler> NotFound(ObjectNotFound e,HttpServletRequest request){
		  Handler err = new Handler(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	  }
}

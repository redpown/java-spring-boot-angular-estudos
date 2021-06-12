package com.springboot.angular.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.angular.controller.exception.handler.ErroPadrao;
import com.springboot.angular.service.exception.IdNaoEncontrado;
import com.springboot.angular.service.exception.NaoPodeDeletarId;

@ControllerAdvice
public class ControllerException {
	
	  @ExceptionHandler(IdNaoEncontrado.class)
	  public ResponseEntity<ErroPadrao> NaoEncontrado(IdNaoEncontrado e,HttpServletRequest request){
		  ErroPadrao err = new ErroPadrao(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	  }
	  
	  @ExceptionHandler(NaoPodeDeletarId.class)
	  public ResponseEntity<ErroPadrao> NaoPode(NaoPodeDeletarId e,HttpServletRequest request){
		  ErroPadrao err = new ErroPadrao(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis());
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	  }
	  
	  @ExceptionHandler(MethodArgumentNotValidException.class)
	  public ResponseEntity<ErroPadrao> Validar(MethodArgumentNotValidException e,HttpServletRequest request){
		  ValidarErros err = new ValidarErros(HttpStatus.BAD_REQUEST.value(),"Erro de validação",System.currentTimeMillis());
		  
		  for(FieldError erro : e.getBindingResult().getFieldErrors()) {
			  err.addErros(erro.getField(),erro.getDefaultMessage());
		  }
		  
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	  }
}

package com.ipersonal.config.security.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;

import com.ipersonal.exception.BaseException;

@ControllerAdvice
public class ResourceExceptionHandlerEndpoints {
 
    @ExceptionHandler({ResourceAccessException.class})
    public ResponseEntity<BaseException> handleAccessDeniedException(Exception ex, HttpServletRequest request) {
    	
    	BaseException erro = new BaseException(HttpStatus.FORBIDDEN, "Acesso Negado", "Acesso Negado", "local");
    	return ResponseEntity.status(HttpStatus.FORBIDDEN).body(erro);
    }
	

}

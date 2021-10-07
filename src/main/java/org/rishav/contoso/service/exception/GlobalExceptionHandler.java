package org.rishav.contoso.service.exception;

import org.rishav.graph.exception.InvalidPathException;
import org.rishav.graph.exception.VertexNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = InvalidPathException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<String> invalidPathException(InvalidPathException invalidPathException) {
		return new ResponseEntity<String>(invalidPathException.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = VertexNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<String> invalidPathException(VertexNotFoundException nodeNotFoundException) {
		return new ResponseEntity<String>(nodeNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}

}
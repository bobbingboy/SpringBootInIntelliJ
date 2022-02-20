package com.bobbingboy.springbootdemo.handler;

import com.bobbingboy.springbootdemo.resource.exception.InvalidRequestException;
import com.bobbingboy.springbootdemo.resource.ErrorResource;
import com.bobbingboy.springbootdemo.resource.FieldResource;
import com.bobbingboy.springbootdemo.resource.InvalidErrorResource;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler {

    //處理Not Found異常
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    @ResponseBody
    public ResponseEntity<?> handlerNotFound(RuntimeException e) {

        ErrorResource errorResource = new ErrorResource(e.getMessage());

        return new ResponseEntity<Object>(errorResource, HttpStatus.NOT_FOUND);
    }

    //處理參數驗證失敗
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseBody
    public ResponseEntity<?> handlerInvalidRequest(InvalidRequestException e) {
        Errors errors = e.getErrors();
        List<FieldResource> fieldResources = new ArrayList<>();

        List<FieldError> fieldErrors = errors.getFieldErrors();
        for (FieldError fieldError: fieldErrors) {
            FieldResource fieldResource = new FieldResource(fieldError.getObjectName(),
                    fieldError.getField(),
                    fieldError.getCode(),
                    fieldError.getDefaultMessage());
            fieldResources.add(fieldResource);
        }
        InvalidErrorResource invalidErrorResource = new InvalidErrorResource(e.getMessage(), fieldResources);
        return new ResponseEntity<Object>(invalidErrorResource, HttpStatus.BAD_REQUEST);
    }

    //處理全局異常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<?> handlerException(Exception e) {
        return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

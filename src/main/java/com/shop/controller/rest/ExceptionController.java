package com.shop.controller.rest;

import com.shop.dto.GeneralErrorDto;
import com.shop.dto.ValidationErrorDto;
import com.shop.service.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

@ControllerAdvice
public class ExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @Autowired
    private ValidationService validationService;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public GeneralErrorDto processServerError(Exception ex) {
        String message = "Server error";
        LOGGER.error(message, ex);
        return new GeneralErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public GeneralErrorDto processNonExistingURL(NoHandlerFoundException ex) {
        String message = "URL not found";
        LOGGER.warn(message, ex);
        return new GeneralErrorDto(HttpStatus.NOT_FOUND.value(), message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorDto processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return validationService.processFieldErrors(HttpStatus.BAD_REQUEST.value(), fieldErrors);
    }

}

package com.shop.service;

import com.shop.dto.ValidationErrorDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import java.util.List;

@Service("validationService")
public class ValidationServiceImpl implements ValidationService {

    @Override
    public ValidationErrorDto processFieldErrors(int errorCode, List<FieldError> fieldErrors) {
        ValidationErrorDto validationErrorDto = new ValidationErrorDto(errorCode);

        for (FieldError fieldError: fieldErrors) {
            validationErrorDto.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return validationErrorDto;
    }
}

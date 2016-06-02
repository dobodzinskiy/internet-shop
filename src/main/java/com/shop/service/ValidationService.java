package com.shop.service;

import com.shop.dto.ValidationErrorDto;
import org.springframework.validation.FieldError;

import java.util.List;

public interface ValidationService {

    ValidationErrorDto processFieldErrors(int errorCode, List<FieldError> fieldErrors);
}

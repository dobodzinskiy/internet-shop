package com.shop.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDto {

    private int errorCode;
    private List<FieldErrorDto> fieldErrors = new ArrayList<>();

    public ValidationErrorDto(int errorCode) {
        this.errorCode = errorCode;
    }

    public void addFieldError(String path, String message) {
        FieldErrorDto fieldErrorDto = new FieldErrorDto(path, message);
        fieldErrors.add(fieldErrorDto);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<FieldErrorDto> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorDto> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}

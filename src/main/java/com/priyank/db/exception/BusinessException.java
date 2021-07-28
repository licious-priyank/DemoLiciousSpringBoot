package com.priyank.db.exception;

import org.springframework.stereotype.Component;

@Component
/*
It is an annotation that allows Spring to automatically detect our custom beans.
What is bean ? Bean is an object that is instantiated, assembled and managed by spring IoC container.
Spring will: Scan our application for classes annotated with @Component.
Instantiate them and inject any specified dependencies into them.
 */
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public BusinessException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessException() {

    }
}


package com.cg.exceptions;

@SuppressWarnings("serial")
public class CategoryException extends RuntimeException {

    private final ErrorCode errorCode;

    public CategoryException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public CategoryException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}

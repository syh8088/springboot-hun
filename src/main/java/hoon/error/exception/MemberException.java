package hoon.error.exception;

import hoon.config.handler.CustomMessageHandler;
import hoon.error.errorCode.ErrorCode;

// NOTE # RuntimeException
public class MemberException extends RuntimeException {

    private ErrorCode errorCode;
    private String message;

    public MemberException(ErrorCode errorCode) {
        super(errorCode.getCode());
        this.errorCode = errorCode;
        this.message = CustomMessageHandler.getMessage(errorCode.getCode());
    }

    @Override
    public String getMessage() {
        return message;
    }
}

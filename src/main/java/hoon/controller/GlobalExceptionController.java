package hoon.controller;

import hoon.error.exception.MemberException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MemberException.class) // NOTE #11 클래스 단위로도 사용 가능(필요한 컨트롤러 내에 선언)
    @ResponseBody
    public String handleBaseException(MemberException e) {
        return e.getMessage();
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException() {
        return "error";
    }
}

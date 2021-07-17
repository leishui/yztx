package com.example.yztx.exception;

import com.example.yztx.constant.StatusType;
import com.example.yztx.msg.SimpleMsg;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyException {
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    SimpleMsg requestTypeMismatch(TypeMismatchException e){
        return new SimpleMsg(StatusType.ERROR_PARA,"1"+e.getErrorCode()
                +":"+e.getPropertyName()
                +":"+e.getRequiredType());
    }
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    SimpleMsg missPara(MissingServletRequestParameterException e){
        return new SimpleMsg(StatusType.ERROR_PARA,"1");
    }
}

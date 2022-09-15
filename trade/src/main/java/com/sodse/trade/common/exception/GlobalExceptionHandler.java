//package com.sodse.trade.common.exception;
//
//
//import com.sodse.trade.common.lang.Result;
//import lombok.extern.slf4j.Slf4j;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@Slf4j//日志
//@RestControllerAdvice//专门捕获controller的异常
//public class GlobalExceptionHandler {
//
////    @ResponseStatus(HttpStatus.UNAUTHORIZED)//反馈，没有权限异常
////    @ExceptionHandler(value =ShiroException.class)
////    public Result handler(ShiroException exception){
////        log.error("运行时的异常:");
////        return Result.fail(401,exception.getMessage(),null);
////    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)//向前端反馈异常
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public Result handler(MethodArgumentNotValidException exception){
//        log.error("实体校验异常:");
//        BindingResult bindingResult=exception.getBindingResult();
//        ObjectError objectError=bindingResult.getAllErrors().stream().findFirst().get();
//
//        return Result.fail(objectError.getDefaultMessage());
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)//向前端反馈异常
//    @ExceptionHandler(value =RuntimeException.class)
//    public Result handler(RuntimeException exception){
//        log.error("运行时的异常:");
//        return Result.fail(exception.getMessage());
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(value = IllegalArgumentException.class)
//    public Result handler(IllegalArgumentException e) {
//        log.error("Assert异常：----------------{}", e);
//        return Result.fail(e.getMessage());
//    }
//
//}

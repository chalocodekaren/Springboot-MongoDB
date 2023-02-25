package playwithjava.in.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.function.Function;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorBean> handleApiException(RuntimeException exception, WebRequest request){
        ErrorBean errorBean=getErrorMsg.apply(exception);
        return new ResponseEntity<ErrorBean>(errorBean, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorBean> handleAnyException(Exception exception){
        ErrorBean errorBean=getErrorMsg.apply(exception);
        return new ResponseEntity<ErrorBean>(errorBean, HttpStatus.BAD_REQUEST);
    }


    Function<Exception,ErrorBean> getErrorMsg=(x)->{
        return ErrorBean.builder()
                .code(500)
                .errorMessage("some error")
                .recommendedAction("Please contact Admin")
                .build();
    };
}

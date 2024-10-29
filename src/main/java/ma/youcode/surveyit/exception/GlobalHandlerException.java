package ma.youcode.surveyit.exception;

import ma.youcode.surveyit.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalHandlerException {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGenericException(Exception e) {

        ErrorDTO errorResponse = new ErrorDTO
                (HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "An error occured: " + e.getMessage(),
                        LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationException(MethodArgumentNotValidException e) {

        ErrorDTO errorResponse = new ErrorDTO
                (HttpStatus.BAD_REQUEST.value(),
                        "errors: " + e.getMessage(),
                        LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}

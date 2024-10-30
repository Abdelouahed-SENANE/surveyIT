package ma.youcode.surveyit.exception;

import ma.youcode.surveyit.dto.ErrorDTO;
import ma.youcode.surveyit.dto.ValidationDTO;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

@RestControllerAdvice
public class RestExceptionHandler {
    private  final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGenericException(Exception e) {

        logger.error("An unexpected error occurred: {}", e.getMessage(), e);

        ErrorDTO errorResponse = new ErrorDTO
                (HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "An error occured: " + e.getMessage(),
                        LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationDTO> handleValidationException(MethodArgumentNotValidException e) {
        Map<String , String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(),  fieldError.getDefaultMessage());
        });

        ValidationDTO errorResponse = new ValidationDTO
                (HttpStatus.BAD_REQUEST.value(),
                         errors,
                        LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}

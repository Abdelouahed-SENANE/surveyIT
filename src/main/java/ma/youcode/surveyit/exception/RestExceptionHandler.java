package ma.youcode.surveyit.exception;

import ma.youcode.surveyit.dto.ErrorDTO;
import ma.youcode.surveyit.dto.ValidationDTO;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.validation.method.ParameterValidationResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

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

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ErrorDTO> HandlerMethodValidationException(HandlerMethodValidationException e) {


        String responseMessage = e.getAllValidationResults().stream()
                .map(result -> {
                    return result.getResolvableErrors().stream()
                            .map(error -> error.getDefaultMessage())
                            .collect(Collectors.joining("; "));
                })
                .filter(message -> !message.isEmpty())
                .collect(Collectors.joining("; "));


        ErrorDTO errorResponse = new ErrorDTO
                (HttpStatus.BAD_REQUEST.value(),
                        responseMessage,
                        LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}

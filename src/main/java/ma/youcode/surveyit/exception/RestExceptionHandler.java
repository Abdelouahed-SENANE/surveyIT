package ma.youcode.surveyit.exception;

import ma.youcode.surveyit.dto.ErrorDTO;
import ma.youcode.surveyit.dto.ValidationDTO;
import ma.youcode.surveyit.repository.SurveyRepository;
import ma.youcode.surveyit.util.Response;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@RestControllerAdvice
public class RestExceptionHandler {
    private  final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    public RestExceptionHandler(SurveyRepository surveyRepository) {
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGenericException(Exception e) {

        logger.error("An unexpected error occurred: {}", e.getMessage(), e);
        return Response.error(400 , e.getMessage() , LocalDateTime.now());

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ValidationDTO> handleValidationException(MethodArgumentNotValidException e) {
        Map<String , String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(),  fieldError.getDefaultMessage());
        });

        ValidationDTO errorResponse = new ValidationDTO
                (400,
                         errors,
                        LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorDTO handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ErrorDTO(404, ex.getMessage(), LocalDateTime.now());
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

        return Response.error(400 , responseMessage , LocalDateTime.now());
    }

}

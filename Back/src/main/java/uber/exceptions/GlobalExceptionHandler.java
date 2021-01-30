package uber.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import uber.exceptions.customs.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{

  /*---------- Spring exception handlers ---------*/

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request)
  {
    List<String> details = new ArrayList<>();

    StringBuilder builder = new StringBuilder();
    builder.append(ex.getContentType());
    builder.append(" media type is not supported. Supported media types are ");
    ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));

    details.add(builder.toString());

    ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Invalid JSON", details);

    return this.buildResponseEntity(apiError);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request)
  {

    List<String> details = new ArrayList<>();
    details.add(ex.getMessage());

    ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Malformed JSON request", details);

    return this.buildResponseEntity(apiError);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request)
  {

    List<String> details;
    details = ex.getBindingResult().getFieldErrors().stream()
        .map(error -> error.getField() + " : " + error.getDefaultMessage()).collect(Collectors.toList());

    ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Validation Errors", details);

    return this.buildResponseEntity(apiError);
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request)
  {

    List<String> details = new ArrayList<>();
    details.add(ex.getParameterName() + " parameter is missing");

    ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Missing Parameters", details);

    return this.buildResponseEntity(apiError);
  }

  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request)
  {

    List<String> details = new ArrayList<>();
    details.add(String.format("Could not find the %s method for URL %s", ex.getHttpMethod(), ex.getRequestURL()));

    ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Method Not Found", details);

    return this.buildResponseEntity(apiError);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
      WebRequest request)
  {
    List<String> details = new ArrayList<>();
    details.add(ex.getMessage());

    ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Mismatch Type", details);

    return this.buildResponseEntity(apiError);
  }

  @ExceptionHandler({ Exception.class })
  public ResponseEntity<Object> handleAll(Exception ex, WebRequest request)
  {

    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());

    ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred", details);

    return this.buildResponseEntity(apiError);
  }

  /*---------- Custom exception handlers ---------*/

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex)
  {
    List<String> details = new ArrayList<>();
    details.add(ex.getMessage());

    ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.NOT_FOUND, "Resource Not Found", details);

    return this.buildResponseEntity(apiError);
  }

  /**
   * Construit et retourne la réponse du serveur au client à partir de l'erreur API en paramètre.
   * 
   * @param apiError
   *          Erreur API décrivant l'exception survenue.
   */
  private ResponseEntity<Object> buildResponseEntity(ApiError apiError)
  {
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }
}

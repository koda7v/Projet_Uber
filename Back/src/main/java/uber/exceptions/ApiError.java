package uber.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError
{

  /**
   * Instance de temps lorsque l'erreur est survenue.
   */
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  protected LocalDateTime timestamp;

  /**
   * Code HTTP de l'erreur (4xx pour les erreurs clients, 5xx pour les erreurs serveurs).
   */
  protected HttpStatus status;

  /**
   * Message décrivant le problème.
   */
  protected String message;

  /**
   * Liste des erreurs survenues.
   */
  protected List<String> errors;

  public ApiError(LocalDateTime timestamp, HttpStatus status, String message, List<String> errors)
  {
    this.timestamp = timestamp;
    this.status = status;
    this.message = message;
    this.errors = errors;
  }

  /*---------- Getters and Setters ---------*/

  public LocalDateTime getTimestamp()
  {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp)
  {
    this.timestamp = timestamp;
  }

  public HttpStatus getStatus()
  {
    return status;
  }

  public void setStatus(HttpStatus status)
  {
    this.status = status;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }

  public List<String> getErrors()
  {
    return errors;
  }

  public void setErrors(List<String> errors)
  {
    this.errors = errors;
  }

}

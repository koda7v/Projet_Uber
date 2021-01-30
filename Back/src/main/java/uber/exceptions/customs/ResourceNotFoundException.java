package uber.exceptions.customs;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception indiquant que la resource recherché n'a pas été trouvée.
 * 
 * @author KAN
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{

  private static final long serialVersionUID = -6439346717348995323L;

  /**
   * Créer l'exception.
   * 
   * @param message
   *          Message détaillant l'exception.
   */
  public ResourceNotFoundException(String message)
  {
    super(message);
  }

}

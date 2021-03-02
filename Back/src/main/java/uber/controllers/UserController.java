package uber.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uber.model.User;
import uber.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController
{
  @Autowired
  UserService userService;

  /**
   * Retourne le user correspondant à l'ID passé en paramètre.
   * 
   * @param id
   *          ID du User recherchée.
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public User getFormation(@PathVariable Long id)
  {
    return this.userService.findUser(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<User> getAllFormations()
  {
    return this.userService.findAllUsers();
  }
}

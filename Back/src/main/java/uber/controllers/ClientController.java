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

import uber.model.Client;
import uber.services.ClientService;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController
{
  @Autowired
  ClientService clientService;

  /**
   * Retourne le client correspondant à l'ID passé en paramètre.
   * 
   * @param id
   *          ID du Client recherchée.
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Client getFormation(@PathVariable Long id)
  {
    return this.clientService.findClient(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Client> getAllFormations()
  {
    return this.clientService.findAllClients();
  }
}

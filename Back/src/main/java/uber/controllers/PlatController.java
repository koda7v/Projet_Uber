package uber.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uber.model.Plat;
import uber.services.PlatService;

@CrossOrigin
@RestController
@RequestMapping("/plat")
public class PlatController
{
  @Autowired
  PlatService platService;

  /**
   * Retourne le plat correspondant à l'ID passé en paramètre.
   * 
   * @param id
   * 
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Plat getPlat(@PathVariable Long id)
  {
    return this.platService.findPlat(id);
  }

  /**
   * retourne une liste de plats
   * 
   * @return
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Plat> getAllPlats()
  {
    return this.platService.findAllPlat();
  }

  /**
   * retourne une liste de plat d'un restaurant
   * 
   * @param idRestaurant
   * @return
   */
  @GetMapping("/searchRestaurant/{idRestaurant}")
  @ResponseStatus(HttpStatus.OK)
  public Set<Plat> findPlatWithRestaurantId(@PathVariable Long idRestaurant)
  {
    return this.platService.findAllPlatsWithRestaurantId(idRestaurant);
  }

}

package uber.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uber.model.Restaurant;
import uber.services.PhotoService;
import uber.services.PlatService;
import uber.services.RestaurantService;

@CrossOrigin
@RestController
@RequestMapping("/restaurant")
public class RestaurantController
{
  @Autowired
  RestaurantService restaurantService;

  @Autowired
  PlatService platService;

  @Autowired
  PhotoService photoService;

  /**
   * Retourne le restaurant correspondant à l'ID passé en paramètre.
   * 
   * @param id
   *          ID du Restaurant recherché.
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Restaurant getRestaurant(@PathVariable Long id)
  {
    return this.restaurantService.findRestaurant(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Restaurant> getAllRestaurants()
  {
    return this.restaurantService.findAllRestaurant();
  }

  @PostMapping
  public Restaurant addRestaurant(@RequestBody @Valid Restaurant restaurant)
  {
    restaurant.setPhoto(this.photoService.findPhoto(this.photoService.savePhoto(restaurant.getPhoto())));
    return this.restaurantService.saveRestaurant(restaurant);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public Restaurant updateRestaurant(@RequestBody @Valid Restaurant restaurant, @RequestParam Long id)
  {
    return this.restaurantService.updateRestaurant(restaurant, id);
  }

}

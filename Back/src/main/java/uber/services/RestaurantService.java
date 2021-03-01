package uber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uber.exceptions.customs.ResourceNotFoundException;
import uber.model.Photo;
import uber.model.Restaurant;
import uber.repository.restaurant.RestaurantRepository;

@Service
public class RestaurantService
{
  @Autowired
  protected RestaurantRepository restaurantRepository;

  @Autowired
  protected PhotoService photoService;

  public Restaurant findRestaurant(Long id)
  {
    return restaurantRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Restaurant avec l'ID : " + id + " pas trouvé!"));
  }

  public List<Restaurant> findAllRestaurant()
  {
    List<Restaurant> restaurants = restaurantRepository.findAll();
    for (Restaurant currentRestaurant : restaurants)
    {
      Long idPhoto = this.restaurantRepository.getIdPhoto(currentRestaurant.getId());
      Photo photo = this.photoService.findPhoto(idPhoto);
      currentRestaurant.setPhoto(photo);
    }
    return restaurants;
  }

}

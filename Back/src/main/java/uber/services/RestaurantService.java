package uber.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uber.exceptions.customs.ResourceNotFoundException;
import uber.model.Commentaire;
import uber.model.Photo;
import uber.model.Plat;
import uber.model.Restaurant;
import uber.repository.restaurant.RestaurantRepository;

@Service
public class RestaurantService
{
  @Autowired
  protected RestaurantRepository restaurantRepository;

  @Autowired
  protected PhotoService photoService;

  @Autowired
  protected PlatService platService;

  @Autowired
  protected CommentaireService commentaireService;

  public Restaurant findRestaurant(Long id)
  {
    Restaurant restaurant = restaurantRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Restaurant avec l'ID : " + id + " pas trouvé!"));
    Long idPhoto = this.restaurantRepository.getIdPhoto(restaurant.getId());
    Photo photo = this.photoService.findPhoto(idPhoto);
    restaurant.setPhoto(photo);

    return restaurant;
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

  public Restaurant saveRestaurant(Restaurant restaurant)
  {
    Long id = this.restaurantRepository.count() + 1;
    this.restaurantRepository.addRestaurant(id, restaurant.getNom(), restaurant.getDescription(),
                                            restaurant.getPhoto().getId());
    return restaurant;
  }

  public Restaurant updateRestaurant(Restaurant restaurant, Long id)
  {
    Long idPhoto = this.restaurantRepository.getIdPhoto(id);
    this.restaurantRepository.updateRestaurant(id, restaurant.getNom(), restaurant.getDescription());
    if (restaurant.getPhoto().getPhoto() == null)
    {
      this.photoService.updatePhoto(this.photoService.findPhoto(idPhoto), idPhoto);
    }
    else
    {
      this.photoService.updatePhoto(restaurant.getPhoto(), idPhoto);
    }
    return this.findRestaurant(id);
  }

  public void deleteRestaurant(@Valid Long idResto)
  {
    Restaurant resto = this.findRestaurant(idResto);
    List<Commentaire> coms = this.commentaireService.findRestoCommentaires(idResto);

    for (Commentaire com : coms)
    {
      this.commentaireService.deleteCommentaire(com.getId());
    }

    for (Plat plat : resto.getPlats())
    {
      this.platService.deletePlat(plat.getId());

    }

    restaurantRepository.deleteRestaurant(idResto);

  }

}

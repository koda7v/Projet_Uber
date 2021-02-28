package uber.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uber.exceptions.customs.ResourceNotFoundException;
import uber.model.Plat;
import uber.repository.plat.PlatRepository;

@Service
public class PlatService
{
  @Autowired
  protected PlatRepository platRepository;

  @Autowired
  protected PhotoService photoService;

  public Plat findPlat(Long id)
  {
    return platRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Plat avec l'ID : " + id + " pas trouvé!"));
  }

  public List<Plat> findAllPlat()
  {
    List<Plat> plats = this.platRepository.findAll();
//    System.out.println(plats.get(0).getDescription());
//    for (Plat currentPlat : plats)
//    {
//      System.out.println(currentPlat.getId());
//      long idPhoto = this.platRepository.getIdPhoto(currentPlat.getId());
//      System.out.println(idPhoto);
//      Photo photo = this.photoService.findPhoto(idPhoto);
//      currentPlat.setPhoto(photo);
//
//    }
    return plats;
  }

  public Set<Plat> findAllPlatsWithRestaurantId(Long IdRestaurant)
  {
    return platRepository.findAllPlatWithRestaurantId(IdRestaurant);
  }
}

package uber.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uber.exceptions.customs.ResourceNotFoundException;
import uber.model.Photo;
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
    return this.platRepository.findAll();
  }

  public Set<Plat> findAllPlatsWithRestaurantId(Long IdRestaurant)
  {
    Set<Plat> plats = platRepository.findAllPlatWithRestaurantId(IdRestaurant);
    for (Plat curerentPlat : plats)
    {
      Long idPhoto = this.platRepository.getIdPhoto(curerentPlat.getId());
      Photo photo = this.photoService.findPhoto(idPhoto);
      curerentPlat.setPhoto(photo);
    }
    return plats;
  }

  public void deletePlat(Long id)
  {
    Plat plat = this.findPlat(id);
    photoService.deletePhoto(plat.getPhoto().getId());
  }

}

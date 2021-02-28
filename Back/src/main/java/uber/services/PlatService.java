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

  public Plat findPlat(Long id)
  {
    return platRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Plat avec l'ID : " + id + " pas trouvé!"));
  }

  public List<Plat> findAllPlat()
  {
    return platRepository.findAll();
  }

  public Set<Plat> findAllPlatsWithRestaurantId(Long IdRestaurant)
  {
    return platRepository.findAllPlatWithRestaurantId(IdRestaurant);
  }
}

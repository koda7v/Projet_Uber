package uber.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uber.exceptions.customs.ResourceNotFoundException;
import uber.model.Panier;
import uber.model.Plat;
import uber.model.PlatRef;
import uber.repository.panier.PanierRepository;

@Service
public class PanierService
{

  @Autowired
  protected PanierRepository panierRepository;

  @Autowired
  protected PlatService platService;

  public Panier findPanier(Long id)
  {
    return panierRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Panier avec l'ID : " + id + " pas trouvé!"));
  }

  public List<Panier> findAllPanier()
  {
    return this.panierRepository.findPaniers();
  }

  public List<Plat> findPlatFromPanier(Long id)
  {
    List<PlatRef> platsRefs = this.panierRepository.findPlatFromPanier(id);
    List<Plat> plats = new ArrayList<>();
    for (PlatRef platRef : platsRefs)
    {
      Plat plat = this.platService.findPlat(platRef.getIdPlat());
      plats.add(plat);
    }

    return plats;
  }

}

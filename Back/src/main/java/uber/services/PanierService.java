package uber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uber.exceptions.customs.ResourceNotFoundException;
import uber.model.Panier;
import uber.repository.panier.PanierRepository;

@Service
public class PanierService
{

  @Autowired
  protected PanierRepository panierRepository;

  public Panier findPanier(Long id)
  {
    return panierRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Panier avec l'ID : " + id + " pas trouvé!"));
  }

  public List<Panier> findAllPanier()
  {
    System.out.println("OOOOZRIHREVUHREVIBREIGVB");
    return this.panierRepository.findPaniers();
  }

}

package uber.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uber.exceptions.customs.ResourceNotFoundException;
import uber.model.HistoriqueCommande;
import uber.repository.historique.HistoriqueRepository;

@Service
public class HistoriqueService
{
  @Autowired
  protected HistoriqueRepository historiqueRepository;

  public HistoriqueCommande findHistorique(Long id)
  {
    return historiqueRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Panier avec l'ID : " + id + " pas trouvé!"));
  }

  public List<HistoriqueCommande> findAllHistorique()
  {
    System.out.println("ouuuui");
    return historiqueRepository.findAll();
  }

  public void addPanierToHistorique(@Valid Long idPan, @Valid Long idUser)
  {
    historiqueRepository.addPanierToHistorique(idPan, idUser);

  }
}

package uber.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uber.exceptions.customs.ResourceNotFoundException;
import uber.model.HistoriqueCommande;
import uber.model.Panier;
import uber.repository.historique.HistoriqueRepository;

@Service
public class HistoriqueService
{
  @Autowired
  protected HistoriqueRepository historiqueRepository;

  @Autowired
  protected PanierService panierService;

  public HistoriqueCommande findHistorique(Long id)
  {
    return historiqueRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Panier avec l'ID : " + id + " pas trouvé!"));
  }

  public List<HistoriqueCommande> findHistoriquesFromUser(Long idUser)
  {
    return historiqueRepository.findHistoriquesFromUser(idUser);

  }

  public List<HistoriqueCommande> findAllHistorique()
  {
    return historiqueRepository.findAll();
  }

  public void addPanierToHistorique(@Valid Long idPan, @Valid Long idUser)
  {
    historiqueRepository.addPanierToHistorique(idPan, idUser);

  }

  public void addPanierToHistorique(@Valid Long idUser)
  {
    Panier panierUser = panierService.findUserPanier(idUser);
    Long idPan = panierUser.getId();
    historiqueRepository.addPanierToHistorique(idPan, idUser);
    panierService.addNewPanierForUser(idUser);

  }

  public List<Panier> retrievePaniersFromUsers(Long idUser)
  {
    return historiqueRepository.retrievePaniersFromUsers(idUser);
  }
}

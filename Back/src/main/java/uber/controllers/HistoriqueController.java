package uber.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uber.model.HistoriqueCommande;
import uber.services.HistoriqueService;

@CrossOrigin
@RestController
@RequestMapping("/historique")
public class HistoriqueController
{
  @Autowired
  HistoriqueService historiqueService;

  /**
   * Retourne l'historique correspondant à l'ID passé en paramètre.
   * 
   * @param id
   * 
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public HistoriqueCommande getHistorique(@PathVariable Long id)
  {
    return this.historiqueService.findHistorique(id);
  }

  /**
   * retourne une liste des historiques
   * 
   * @return
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<HistoriqueCommande> getAllHistorique()
  {
    System.out.println("ouuu");
    return this.historiqueService.findAllHistorique();
  }
}

package uber.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uber.model.Panier;
import uber.model.Plat;
import uber.services.PanierService;

@CrossOrigin
@RestController
@RequestMapping("/panier")
public class PanierController
{
  @Autowired
  PanierService panierService;

  /**
   * Retourne le panier correspondant à l'ID passé en paramètre.
   * 
   * @param id
   * 
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Panier getPanier(@PathVariable Long id)
  {
    return this.panierService.findPanier(id);
  }

  /**
   * retourne une liste des paniers
   * 
   * @return
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Panier> getAllPaniers()
  {
    return this.panierService.findAllPanier();
  }

  @GetMapping("plats/{id}")
  @ResponseStatus(HttpStatus.OK)
  public List<Plat> findPlatFromPanier(@PathVariable Long id)
  {
    return this.panierService.findPlatFromPanier(id);
  }

  /**
   * 
   * @param id
   *          l'id d'un user
   * @return
   */
  @GetMapping("user/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Panier findUserPanier(@PathVariable Long id)
  {
    return this.panierService.findUserPanier(id);
  }

  @PostMapping
  public void addPlatToUserPanier(@Valid @RequestParam Long idUser, @Valid @RequestParam Long idPlat)
  {
    this.panierService.addPlatToUserPanier(idUser, idPlat);
  }

  @PostMapping("delete")
  public void deletePlatFromActivePanier(@Valid @RequestParam Long idUser, @Valid @RequestParam Long idPlat)
  {
    this.panierService.deletePlatFromActivePanier(idUser, idPlat);
  }

}

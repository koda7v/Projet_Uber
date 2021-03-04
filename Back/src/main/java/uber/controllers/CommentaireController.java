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

import uber.model.Commentaire;
import uber.services.CommentaireService;

@CrossOrigin
@RestController
@RequestMapping("/commentaire")
public class CommentaireController
{
  @Autowired
  CommentaireService commentaireService;

  /**
   * Retourne le Commentaire correspondant à l'ID passé en paramètre.
   * 
   * @param id
   * 
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Commentaire getCommentaire(@PathVariable Long id)
  {
    return this.commentaireService.findCommentaire(id);
  }

  /**
   * retourne une liste des Commentaires
   * 
   * @return
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Commentaire> getAllCommentaires()
  {
    return this.commentaireService.findAllCommentaire();
  }
}

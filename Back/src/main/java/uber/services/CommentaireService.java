package uber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uber.exceptions.customs.ResourceNotFoundException;
import uber.model.Commentaire;
import uber.repository.commentaire.CommentaireRepository;

@Service
public class CommentaireService
{
  @Autowired
  CommentaireRepository commentaireRepository;

  public Commentaire findCommentaire(Long id)
  {
    return commentaireRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Commentaier avec l'ID : " + id + " pas trouvé!"));
  }

  public List<Commentaire> findAllCommentaire()
  {
    return commentaireRepository.findCommentaires();
  }

  public List<Commentaire> findRestoCommentaires(Long id)
  {
    // TODO Auto-generated method stub
    return commentaireRepository.findRestoCommentaires(id);
  }

  public void deleteCommentaire(Long id)
  {
    this.commentaireRepository.deleteById(id);

  }
}

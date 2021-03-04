package uber.repository.commentaire;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import uber.model.Commentaire;

@Repository
public interface CommentaireRepository extends PagingAndSortingRepository<Commentaire, Long>
{
  @Query("SELECT " + CommentaireConstantSQL.TABLE_NAME + ".*" + " FROM " + CommentaireConstantSQL.TABLE_NAME)
  List<Commentaire> findCommentaires();
}

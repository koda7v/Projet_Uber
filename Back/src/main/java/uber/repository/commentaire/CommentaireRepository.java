package uber.repository.commentaire;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uber.model.Commentaire;

@Repository
public interface CommentaireRepository extends PagingAndSortingRepository<Commentaire, Long>
{
  @Query("SELECT " + CommentaireConstantSQL.TABLE_NAME + ".*" + " FROM " + CommentaireConstantSQL.TABLE_NAME)
  List<Commentaire> findCommentaires();

  @Query("SELECT " + CommentaireConstantSQL.TABLE_NAME + ".*" + " FROM " + CommentaireConstantSQL.TABLE_NAME + " WHERE "
      + CommentaireConstantSQL.FK_ID_RESTO_COLUMN_NAME + " = :idResto")
  List<Commentaire> findRestoCommentaires(@Param("idResto") Long idResto);

  @Modifying
  @Query("INSERT INTO " + CommentaireConstantSQL.TABLE_NAME + " ( " + CommentaireConstantSQL.TABLE_NAME + "."
      + CommentaireConstantSQL.TEXTE_COLUMN_NAME + ", " + CommentaireConstantSQL.TABLE_NAME + "."
      + CommentaireConstantSQL.FK_ID_RESTO_COLUMN_NAME + ", " + CommentaireConstantSQL.TABLE_NAME + "."
      + CommentaireConstantSQL.FK_ID_USER_COLUMN_NAME + " )  VALUES ( :texte, :idResto, :idUser)")
  void addCommentaire(@Param("texte") String texte, @Param("idUser") Long idUser, @Param("idResto") Long idResto);

}

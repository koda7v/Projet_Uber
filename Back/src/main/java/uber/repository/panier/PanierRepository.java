package uber.repository.panier;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import uber.model.Panier;

@Repository
public interface PanierRepository extends PagingAndSortingRepository<Panier, Long>
{
  /**
   * Récupère les paniers correspondant à l'id d'un user.
   * 
   * @param
   * @return
   */

  @Query("SELECT " + PanierConstantSQL.TABLE_NAME + ".*" + " FROM " + PanierConstantSQL.TABLE_NAME + " WHERE "
      + PanierConstantSQL.TABLE_NAME + "." + PanierConstantSQL.FK_ID_USER_COLUMN_NAME + " = 1")
  List<Panier> findPaniers();

}

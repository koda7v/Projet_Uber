package uber.repository.panier;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uber.model.Panier;
import uber.model.PlatRef;
import uber.repository.plat.PlatConstantSQL;
import uber.repository.user.UserConstantsSQL;

@Repository
public interface PanierRepository extends PagingAndSortingRepository<Panier, Long>
{
  /**
   * Récupère les paniers correspondant à l'id d'un user.
   * 
   * @param
   * @return
   */

  @Query("SELECT " + PanierConstantSQL.TABLE_NAME + ".*" + " FROM " + PanierConstantSQL.TABLE_NAME)
  List<Panier> findPaniers();

  @Query("SELECT " + PlatConstantSQL.ID_COLUMN_NAME + " FROM " + PanierConstantSQL.PLAT_PANIER_ASSOCIATION + " WHERE "
      + PanierConstantSQL.ID_COLUMN_NAME + " = (SELECT " + PanierConstantSQL.ID_COLUMN_NAME + " FROM "
      + PanierConstantSQL.TABLE_NAME + " WHERE " + UserConstantsSQL.ID_COLUMN_NAME + " = :idUser)")
  List<PlatRef> findPlatFromPanier(@Param("idUser") Long idUser);

  @Query("SELECT  " + PanierConstantSQL.TABLE_NAME + ".*" + " FROM " + PanierConstantSQL.TABLE_NAME
      + " WHERE use_id = :idUser)")
  Panier findUserPanier(@Param("idUser") Long idUser);

  /**
   * Utiliser findUserPanier pour passer l'idPan
   * 
   * @param idPan
   * @param idPlat
   */
  @Query("INSERT INTO " + PanierConstantSQL.PLAT_PANIER_ASSOCIATION + " ( " + PanierConstantSQL.ID_COLUMN_NAME + " , "
      + PlatConstantSQL.ID_COLUMN_NAME + " )  VALUES ( :idPan, " + " (SELECT " + PlatConstantSQL.ID_COLUMN_NAME
      + " FROM " + PlatConstantSQL.TABLE_NAME + " WHERE " + PlatConstantSQL.ID_COLUMN_NAME + " = :idPlat ))")

  void addPlatToUserPanier(@Param("idPan") Long idPan, @Param("idPlat") Long idPlat);

}

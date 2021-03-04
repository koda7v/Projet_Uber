package uber.repository.panier;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
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

  /**
   * Selectionne le dernier panier actif de l'utilisateur (pour l'instant l'id le plus grand est l'actif)
   * 
   * @param idUser
   * @return
   */
  @Query("SELECT " + PanierConstantSQL.TABLE_NAME + ".*" + " FROM " + PanierConstantSQL.TABLE_NAME + " WHERE "
      + PanierConstantSQL.TABLE_NAME + "." + PanierConstantSQL.FK_ID_USER_COLUMN_NAME + " = :idUser ORDER BY "
      + PanierConstantSQL.ID_COLUMN_NAME + " DESC LIMIT 1")
  Panier findUserPanier(@Param("idUser") Long idUser);

  /**
   * Utiliser findUserPanier pour passer l'idPan
   * 
   * @param idPan
   * @param idPlat
   */

  @Modifying
  @Query("INSERT INTO " + PanierConstantSQL.PLAT_PANIER_ASSOCIATION + " ( " + PanierConstantSQL.PLAT_PANIER_ASSOCIATION
      + "." + PanierConstantSQL.FK_ID__COLUMN_NAME + ", " + PanierConstantSQL.PLAT_PANIER_ASSOCIATION + "."
      + PlatConstantSQL.ID_COLUMN_NAME + " )  VALUES ( :idPan, (SELECT " + PlatConstantSQL.TABLE_NAME + "."
      + PlatConstantSQL.ID_COLUMN_NAME + " FROM " + PlatConstantSQL.TABLE_NAME + " WHERE " + PlatConstantSQL.TABLE_NAME
      + "." + PlatConstantSQL.ID_COLUMN_NAME + " = :idPlat ))")
  void addPlatToUserPanier(@Param("idPan") Long idPan, @Param("idPlat") Long idPlat);

  @Modifying
  @Query("INSERT INTO " + PanierConstantSQL.TABLE_NAME + " ( " + PanierConstantSQL.TABLE_NAME + "."
      + PanierConstantSQL.TOTAL_COLUMN_NAME + ", " + PanierConstantSQL.TABLE_NAME + "."
      + PanierConstantSQL.FK_ID_USER_COLUMN_NAME + " )  VALUES ( 0, :idUser)")
  void addNewPanierForUser(@Param("idUser") Long idUser);
}

package uber.repository.historique;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uber.model.HistoriqueCommande;
import uber.model.Panier;
import uber.repository.panier.PanierConstantSQL;
import uber.repository.plat.PlatConstantSQL;

@Repository
public interface HistoriqueRepository extends PagingAndSortingRepository<HistoriqueCommande, Long>
{
  @Override
  public List<HistoriqueCommande> findAll();

  @Query("SELECT " + HistoriqueConstantSQL.TABLE_NAME + ".* " + " FROM " + PlatConstantSQL.TABLE_NAME + " WHERE "
      + HistoriqueConstantSQL.TABLE_NAME + "." + HistoriqueConstantSQL.FK_ID_USER_COLUMN_NAME + " = :idUser")
  public List<HistoriqueCommande> findHistoriquesFromUser(@Param("idUser") Long idUser);

  @Modifying
  @Query("INSERT INTO " + HistoriqueConstantSQL.TABLE_NAME + " ( " + HistoriqueConstantSQL.TABLE_NAME + "."
      + HistoriqueConstantSQL.FK_ID_PANIER_COLUMN_NAME + ", " + HistoriqueConstantSQL.TABLE_NAME + "."
      + HistoriqueConstantSQL.FK_ID_USER_COLUMN_NAME + ", " + HistoriqueConstantSQL.TABLE_NAME + "."
      + HistoriqueConstantSQL.PAYE_COLUMN_NAME + " )  VALUES ( :idPan, :idUser, 1 )")
  public void addPanierToHistorique(@Param("idPan") Long idPan, @Param("idUser") Long idUser);

  @Query("SELECT " + PanierConstantSQL.TABLE_NAME + "." + "*" + " FROM " + PanierConstantSQL.TABLE_NAME + " WHERE "
      + HistoriqueConstantSQL.TABLE_NAME + "." + PanierConstantSQL.ID_COLUMN_NAME + " = (SELECT "
      + HistoriqueConstantSQL.TABLE_NAME + "." + PanierConstantSQL.ID_COLUMN_NAME + " FROM "
      + HistoriqueConstantSQL.TABLE_NAME + " WHERE " + PanierConstantSQL.TABLE_NAME + "."
      + PanierConstantSQL.FK_ID_USER_COLUMN_NAME + " = :idUser )")
  public List<Panier> retrievePaniersFromUsers(@Param("idUser") Long idUser);
}

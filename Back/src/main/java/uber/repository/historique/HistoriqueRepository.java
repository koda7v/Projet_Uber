package uber.repository.historique;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uber.model.HistoriqueCommande;

@Repository
public interface HistoriqueRepository extends PagingAndSortingRepository<HistoriqueCommande, Long>
{
  @Override
  public List<HistoriqueCommande> findAll();

  @Modifying
  @Query("INSERT INTO " + HistoriqueConstantSQL.TABLE_NAME + " ( " + HistoriqueConstantSQL.TABLE_NAME + "."
      + HistoriqueConstantSQL.FK_ID_PANIER_COLUMN_NAME + ", " + HistoriqueConstantSQL.TABLE_NAME + "."
      + HistoriqueConstantSQL.FK_ID_USER_COLUMN_NAME + " )  VALUES ( :idPan, :idUser, 1 )")
  void addPanierToHistorique(@Param("idPan") Long idPan, @Param("idUser") Long idUser);
}

package uber.repository.plat;

import java.util.List;
import java.util.Set;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uber.model.Plat;

@Repository
public interface PlatRepository extends PagingAndSortingRepository<Plat, Long>
{
  @Override
  List<Plat> findAll();

  /**
   * Récupère les plats en fonction de l'id du restaurant
   * 
   * @param idRestaurant
   *          ID du Restaurant.
   * @return Le nombre de plats trouvés.
   */
  @Query("SELECT " + PlatConstantSQL.TABLE_NAME + ".* " + "FROM " + PlatConstantSQL.TABLE_NAME + " WHERE "
      + PlatConstantSQL.TABLE_NAME + "." + PlatConstantSQL.FK_ID_RESTAURANT_COLUMN_NAME + " = :idRestaurant")
  Set<Plat> findAllPlatWithRestaurantId(@Param("idRestaurant") Long idRestaurant);
}

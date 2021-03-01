package uber.repository.restaurant;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uber.model.Restaurant;

@Repository
public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Long>
{
  @Override
  List<Restaurant> findAll();

  @Query("SELECT " + RestaurantConstantSQL.TABLE_NAME + "." + RestaurantConstantSQL.PHOTO_COLUMN_NAME + " FROM "
      + RestaurantConstantSQL.TABLE_NAME + " WHERE " + RestaurantConstantSQL.TABLE_NAME + "."
      + RestaurantConstantSQL.ID_COLUMN_NAME + " = :idRestaurant")
  Long getIdPhoto(@Param("idRestaurant") Long idRestaurant);

}

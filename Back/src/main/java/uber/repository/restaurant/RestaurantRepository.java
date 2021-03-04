package uber.repository.restaurant;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
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

  @Modifying
  @Query("INSERT INTO " + RestaurantConstantSQL.TABLE_NAME + " ( " + RestaurantConstantSQL.ID_COLUMN_NAME + " , "
      + RestaurantConstantSQL.NOM_COLUMN_NAME + " , " + RestaurantConstantSQL.DESCRIPTION_COLUMN_NAME + " , "
      + RestaurantConstantSQL.PHOTO_COLUMN_NAME + " )  VALUES ( :id, :name, :description , :idPhoto )")
  void addRestaurant(@Param("id") Long id, @Param("name") String name, @Param("description") String description,
      @Param("idPhoto") Long idPhoto);

  @Modifying
  @Query("UPDATE " + RestaurantConstantSQL.TABLE_NAME + " SET " + RestaurantConstantSQL.NOM_COLUMN_NAME + " = :name, "
      + RestaurantConstantSQL.DESCRIPTION_COLUMN_NAME + " = :description WHERE " + RestaurantConstantSQL.ID_COLUMN_NAME
      + " = :id")
  void updateRestaurant(@Param("id") Long id, @Param("name") String name, @Param("description") String description);

}

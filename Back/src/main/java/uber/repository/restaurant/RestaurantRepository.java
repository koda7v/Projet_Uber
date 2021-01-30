package uber.repository.restaurant;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import uber.model.Restaurant;

@Repository
public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Long>
{
  @Override
  List<Restaurant> findAll();
}

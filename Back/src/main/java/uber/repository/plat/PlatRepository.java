package uber.repository.plat;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import uber.model.Plat;

@Repository
public interface PlatRepository extends PagingAndSortingRepository<Plat, Long>
{
  @Override
  List<Plat> findAll();
}

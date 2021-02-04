package uber.repository.photo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import uber.model.Photo;

public interface PhotoRepository extends PagingAndSortingRepository<Photo, Long>
{
  @Override
  public List<Photo> findAll();

}

package uber.repository.client;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import uber.model.Client;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Long>
{
  @Override
  List<Client> findAll();
}

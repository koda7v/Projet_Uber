package uber.repository.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import uber.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>
{
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  @Override
  List<User> findAll();
}

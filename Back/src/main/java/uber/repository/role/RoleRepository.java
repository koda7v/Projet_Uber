package uber.repository.role;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import uber.model.ERole;
import uber.model.Role;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long>
{
  @Override
  List<Role> findAll();

  Optional<Role> findByName(ERole name);

}

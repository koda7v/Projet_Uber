package uber.repository.client;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uber.model.ERole;
import uber.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{
  Optional<Role> findByName(ERole name);
}

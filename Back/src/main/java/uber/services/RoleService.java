package uber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uber.exceptions.customs.ResourceNotFoundException;
import uber.model.Role;
import uber.repository.role.RoleRepository;

@Service
public class RoleService
{
  @Autowired
  protected RoleRepository roleRepository;

  public Role findRole(Long id)
  {
    return roleRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Role avec l'ID : " + id + " pas trouvé!"));
  }

  public List<Role> findAllRoles()
  {
    return roleRepository.findAll();
  }

}

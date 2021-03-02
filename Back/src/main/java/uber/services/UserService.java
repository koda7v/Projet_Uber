package uber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uber.exceptions.customs.ResourceNotFoundException;
import uber.model.User;
import uber.repository.user.UserRepository;

@Service
public class UserService
{
  @Autowired
  protected UserRepository userRepository;

  public User findUser(Long id)
  {
    return userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User avec l'ID : " + id + " pas trouvé!"));
  }

  public List<User> findAllUsers()
  {
    return userRepository.findAll();
  }

}

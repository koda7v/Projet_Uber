package uber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uber.exceptions.customs.ResourceNotFoundException;
import uber.model.Client;
import uber.repository.client.ClientRepository;

@Service
public class ClientService
{
  @Autowired
  protected ClientRepository clientRepository;

  public Client findClient(Long id)
  {
    return clientRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Client avec l'ID : " + id + " pas trouvé!"));
  }

  public List<Client> findAllClients()
  {
    return clientRepository.findAll();
  }

}

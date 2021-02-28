package uber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uber.exceptions.customs.ResourceNotFoundException;
import uber.model.Photo;
import uber.repository.photo.PhotoRepository;

@Service
public class PhotoService
{
  @Autowired
  protected PhotoRepository photoRepository;

  public Photo findPhoto(Long id)
  {
    return photoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Photo avec l'ID : " + id + " pas trouvé!"));
  }

  public List<Photo> findAllPhoto()
  {
    return photoRepository.findAll();
  }

}

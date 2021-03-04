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

  public Long savePhoto(Photo photo)
  {
    Long id = this.photoRepository.count() + 1;
    this.photoRepository.addPhoto(id, photo.getName(), photo.getPhoto(), photo.getCommentaire());
    return id;
  }

  public void updatePhoto(Photo photo, Long id)
  {
    this.photoRepository.updatePhoto(id, photo.getPhoto(), photo.getName(), photo.getCommentaire());
  }

  public void deletePhoto(Long id)
  {
    // this.photoRepository

  }

}

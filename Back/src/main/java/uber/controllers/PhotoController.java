package uber.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uber.model.Photo;
import uber.services.PhotoService;

@CrossOrigin
@RestController
@RequestMapping("/photo")
public class PhotoController
{
  @Autowired
  PhotoService photoService;

  /**
   * Retourne la photo correspondante à l'ID passé en paramètre.
   * 
   * @param id
   *          ID de la photo recherchée.
   * @return
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Photo getPhoto(@PathVariable Long id)
  {
    return this.photoService.findPhoto(id);
  }

  @GetMapping("/files")
  public List<Photo> getListFiles()
  {
    List<Photo> files = photoService.findAllPhoto();

//      return new ResponseFile(
//          photo.getName(),
//          photo.getCommentaire();
//          fileDownloadUri,
//          photo.getType(),
//          photo.getData().length);
//    }).collect(Collectors.toList());

    return files;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Photo> getAllPhoto()
  {
    return this.photoService.findAllPhoto();
  }

}

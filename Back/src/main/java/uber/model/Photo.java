package uber.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import uber.repository.photo.PhotoConstantSQL;

@Table(PhotoConstantSQL.TABLE_NAME)
public class Photo
{
  @Id
  @Column(PhotoConstantSQL.ID_COLUMN_NAME)
  protected Long id;

  @NotEmpty
  // @Column(PhotoConstantSQL.PHOTO_COLUMN_NAME, 1000)
  private byte[] photo;

  @NotEmpty
  @Column(PhotoConstantSQL.COMMENTAIRE_COLUMN_NAME)
  protected String commentaire;

  public Photo(Long id, byte[] photo, String commentaire)
  {
    this.id = id;
    this.photo = photo;
    this.commentaire = commentaire;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public byte[] getPhoto()
  {
    return photo;
  }

  public void setPhoto(byte[] photo)
  {
    this.photo = photo;
  }

  public String getCommentaire()
  {
    return commentaire;
  }

  public void setCommentaire(String commentaire)
  {
    this.commentaire = commentaire;
  }

}

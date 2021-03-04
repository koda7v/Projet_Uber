package uber.model;

import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import uber.repository.photo.PhotoConstantSQL;

@Table(PhotoConstantSQL.TABLE_NAME)
public class PhotoFront
{
  @Id
  @Column(PhotoConstantSQL.ID_COLUMN_NAME)
  protected Long id;

  @NotEmpty
  @Column(PhotoConstantSQL.NAME_COLUMN_NAME)
  protected String name;

  @NotEmpty
  @Lob
  @Column(PhotoConstantSQL.BLOB_COLUMN_NAME)
  protected String photo;

  @NotEmpty
  @Column(PhotoConstantSQL.COMMENTAIRE_COLUMN_NAME)
  protected String commentaire;

  public PhotoFront(Long id, String name, String photo, String commentaire)
  {
    this.id = id;
    this.name = name;
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

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getPhoto()
  {
    return photo;
  }

  public void setPhoto(String photo)
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

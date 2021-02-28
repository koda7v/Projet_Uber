package uber.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import uber.repository.plat.PlatConstantSQL;

@Table(PlatConstantSQL.TABLE_NAME)
public class Plat
{

  @Id
  @Column(PlatConstantSQL.ID_COLUMN_NAME)
  protected Long id;

  @NotEmpty
  @Column(PlatConstantSQL.NOM_COLUMN_NAME)
  protected String nom;

  @NotEmpty
  @Column(PlatConstantSQL.DESCRIPTION_COLUMN_NAME)
  protected String description;

  @NotEmpty
  @Column(PlatConstantSQL.PRIX_COLUMN_NAME)
  protected Integer prix;

  @Column(PlatConstantSQL.PHOTO_COLUMN_ID)
  protected Photo photo;

  public Plat(Long id, String nom, String description, Integer prix, Photo photo)
  {
    this.id = id;
    this.nom = nom;
    this.description = description;
    this.prix = prix;
    this.photo = photo;
  }

  public Photo getPhoto()
  {
    return photo;
  }

  public void setPhoto(Photo photo)
  {
    this.photo = photo;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getNom()
  {
    return nom;
  }

  public void setNom(String nom)
  {
    this.nom = nom;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public Integer getPrix()
  {
    return prix;
  }

  public void setPrix(Integer prix)
  {
    this.prix = prix;
  }

}

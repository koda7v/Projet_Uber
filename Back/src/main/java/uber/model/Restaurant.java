package uber.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import uber.repository.restaurant.RestaurantConstantSQL;

@Table(RestaurantConstantSQL.TABLE_NAME)
public class Restaurant
{
  @Id
  @Column(RestaurantConstantSQL.ID_COLUMN_NAME)
  protected Long id;

  @NotEmpty
  @Column(RestaurantConstantSQL.NOM_COLUMN_NAME)
  protected String nom;

  @NotEmpty
  @Column(RestaurantConstantSQL.DESCRIPTION_COLUMN_NAME)
  protected String description;

  @Column(RestaurantConstantSQL.PHOTO_COLUMN_NAME)
  protected Photo photo;

  @MappedCollection(keyColumn = RestaurantConstantSQL.ID_COLUMN_NAME, idColumn = RestaurantConstantSQL.FK_ID_RESTAURANT_COLUMN)
  protected Set<Plat> plats;

  public Restaurant(Long id, String nom, String description, Photo photo)
  {
    this.id = id;
    this.nom = nom;
    this.description = description;
    this.photo = photo;

    this.plats = new HashSet<>();
  }

  /*---------- Plats ---------*/

  public void addPlat(Plat plat)
  {
    this.plats.add(plat);
  }

  /*---------- Getters and Setters ---------*/

  public Long getId()
  {
    return id;
  }

  public Photo getPhoto()
  {
    return photo;
  }

  public void setPhoto(Photo photo)
  {
    this.photo = photo;
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

  public Set<Plat> getPlats()
  {
    return plats;
  }

  public void setPlats(Set<Plat> plats)
  {
    this.plats = plats;
  }

}

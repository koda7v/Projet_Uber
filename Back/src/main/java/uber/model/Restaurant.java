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

  @MappedCollection(keyColumn = RestaurantConstantSQL.ID_COLUMN_NAME, idColumn = RestaurantConstantSQL.FK_ID_RESTAURANT_COLUMN)
  protected Set<Plat> plats;

  public Restaurant(Long id, String nom, String description)
  {
    this.id = id;
    this.nom = nom;
    this.description = description;

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

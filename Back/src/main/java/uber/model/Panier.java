package uber.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import uber.repository.panier.PanierConstantSQL;

@Table(PanierConstantSQL.TABLE_NAME)
public class Panier
{
  @Id
  @Column(PanierConstantSQL.ID_COLUMN_NAME)
  protected Long id;

  @Column(PanierConstantSQL.TOTAL_COLUMN_NAME)
  protected Long total;

  @Column(PanierConstantSQL.DATE_COLUMN_NAME)
  protected Date date;

  @Column(PanierConstantSQL.FK_ID_USER_COLUMN_NAME)
  protected Long idUser;

  @MappedCollection(keyColumn = PanierConstantSQL.ID_COLUMN_NAME, idColumn = PanierConstantSQL.ID_COLUMN_NAME)
  protected List<PlatRef> platsRef;

  public Panier(Long id, Long total, Date date, Long idUser)
  {
    this.id = id;
    this.total = total;
    this.date = date;
    this.idUser = idUser;

    this.platsRef = new ArrayList<>();
  }

  /*---------- Plats ---------*/

//  public void addPlat(List<Plat> plats)
//  {
//    for (Plat plat : plats)
//    {
//      this.addPlatRef(plat);
//    }
//  }

  public void addPlat(Plat plat)
  {
    this.platsRef.add(new PlatRef(plat.getId()));
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

  public Long getTotal()
  {
    return total;
  }

  public void setTotal(Long total)
  {
    this.total = total;
  }

  public Date getDate()
  {
    return date;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  public Long getIdUser()
  {
    return idUser;
  }

  public void setIdUser(Long idUser)
  {
    this.idUser = idUser;
  }

  public List<PlatRef> getPlatsRef()
  {
    return platsRef;
  }

  public void setPlatsRef(List<PlatRef> plats)
  {
    this.platsRef = plats;
  }

}

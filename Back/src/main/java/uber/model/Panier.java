package uber.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Panier
{
  @Id
  protected Long id;

  protected Long total;

  protected Date date;

  @Id
  protected Long idClient;

  protected List<Plat> plats;

  public Panier(Long id, Long total, Date date, Long idClient)
  {
    this.id = id;
    this.total = total;
    this.date = date;
    this.idClient = idClient;

    this.plats = new ArrayList<>();
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

  public Long getIdClient()
  {
    return idClient;
  }

  public void setIdClient(Long idClient)
  {
    this.idClient = idClient;
  }

  public List<Plat> getPlats()
  {
    return plats;
  }

  public void setPlats(List<Plat> plats)
  {
    this.plats = plats;
  }

}

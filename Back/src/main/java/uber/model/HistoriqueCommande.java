package uber.model;

import org.springframework.data.annotation.Id;

public class HistoriqueCommande
{

  @Id
  protected Long id;

  @Id
  protected Long idUser;

  public HistoriqueCommande(Long id, Long idUser)
  {
    this.id = id;
    this.idUser = idUser;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public Long getIdUser()
  {
    return idUser;
  }

  public void setIdUser(Long idUser)
  {
    this.idUser = idUser;
  }

}

package uber.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import uber.repository.historique.HistoriqueConstantSQL;

@Table(HistoriqueConstantSQL.TABLE_NAME)
public class HistoriqueCommande
{

  @Id
  @NotEmpty
  @Column(HistoriqueConstantSQL.ID_COLUMN_NAME)
  protected Long id;

  @NotEmpty
  @Column(HistoriqueConstantSQL.PAYE_COLUMN_NAME)
  protected boolean paye;

  @NotEmpty
  @Column(HistoriqueConstantSQL.FK_ID_USER_COLUMN_NAME)
  protected Long idUser;

  public HistoriqueCommande(Long id, boolean paye, Long idUser)
  {
    this.id = id;
    this.paye = paye;
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

  public boolean isPaye()
  {
    return paye;
  }

  public void setPaye(boolean paye)
  {
    this.paye = paye;
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

package uber.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import uber.repository.plat.PlatConstantSQL;

@Table(PlatConstantSQL.PLAT_PANIER_ASSOCIATION)
public class PlatRef
{

  @Column(PlatConstantSQL.ID_COLUMN_NAME)
  Long idPlat;

  public PlatRef(Long idPlat)
  {
    this.idPlat = idPlat;
  }

  public Long getIdPlat()
  {
    return idPlat;
  }

  public void setIdPlat(Long idPlat)
  {
    this.idPlat = idPlat;
  }

}

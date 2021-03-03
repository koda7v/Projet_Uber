package uber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import uber.repository.role.RoleConstantSQL;

@Entity
@Table(name = "t_roles_rol")
public class Role
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = RoleConstantSQL.ID_COLUMN_NAME)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(name = RoleConstantSQL.NOM_COLUMN_NAME)
  private ERole name;

  public Role()
  {

  }

  public Role(ERole name)
  {
    this.name = name;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public ERole getName()
  {
    return name;
  }

  public void setName(ERole name)
  {
    this.name = name;
  }
}
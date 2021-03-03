package uber.repository.role;

public class RoleConstantSQL
{
  private RoleConstantSQL()
  {
    throw new IllegalStateException("Utility class");
  }

  /*---------- Table ---------*/

  public static final String TABLE_NAME = "t_roles_rol";

  /*---------- Colonne ---------*/

  public static final String ID_COLUMN_NAME = "rol_id";

  public static final String NOM_COLUMN_NAME = "rol_name";

}

package uber.repository.panier;

public class PanierConstantSQL
{
  private PanierConstantSQL()
  {
    throw new IllegalStateException("Utility class");
  }

  /*---------- Table ---------*/
  public static final String TABLE_NAME = "t_panier_pan";

  /*---------- Colonne ---------*/
  public static final String ID_COLUMN_NAME = "pan_id";

  public static final String TOTAL_COLUMN_NAME = "pan_total";

  public static final String DATE_COLUMN_NAME = "pan_data";

  /*---------- Clés étrangères ---------*/

  public static final String FK_ID_USER_COLUMN_NAME = "use_id";

  /*---------- Table de jointure ---------*/

  // public static final String JOIN_TABLE_PANIER_PLAT_NAME = "t_panier_plat_tpp";
}

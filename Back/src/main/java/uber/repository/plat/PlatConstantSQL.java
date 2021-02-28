package uber.repository.plat;

public class PlatConstantSQL
{
  private PlatConstantSQL()
  {
    throw new IllegalStateException("Utility class");
  }

  /*---------- Table ---------*/
  public static final String TABLE_NAME = "t_plat_plt";

  /*---------- Colonne ---------*/
  public static final String ID_COLUMN_NAME = "plt_id";

  public static final String NOM_COLUMN_NAME = "plt_nom";

  public static final String DESCRIPTION_COLUMN_NAME = "plt_description";

  public static final String PRIX_COLUMN_NAME = "plt_prix";

  public static final String PHOTO_COLUMN_ID = "pht_id";

  /*---------- Clés étrangères ---------*/

  public static final String FK_ID_RESTAURANT_COLUMN_NAME = "rst_id";
}

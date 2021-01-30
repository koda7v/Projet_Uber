package uber.repository.restaurant;

public class RestaurantConstantSQL
{
  private RestaurantConstantSQL()
  {
    throw new IllegalStateException("Utility class");
  }

  /*---------- Table ---------*/

  public static final String TABLE_NAME = "t_restaurant_rst";

  /*---------- Colonne ---------*/

  public static final String ID_COLUMN_NAME = "rst_id";

  public static final String NOM_COLUMN_NAME = "rst_nom";

  public static final String DESCRIPTION_COLUMN_NAME = "rst_description";

  /*---------- Clés étrangères ---------*/

  public static final String FK_ID_RESTAURANT_COLUMN = "rst_id";
}

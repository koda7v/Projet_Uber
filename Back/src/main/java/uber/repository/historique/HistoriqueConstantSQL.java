package uber.repository.historique;

public class HistoriqueConstantSQL
{
  private HistoriqueConstantSQL()
  {
    throw new IllegalStateException("Utility class");
  }

  /*---------- Table ---------*/
  public static final String TABLE_NAME = "t_historique_hst";

  /*---------- Colonne ---------*/
  public static final String ID_COLUMN_NAME = "hst_id";

  public static final String PAYE_COLUMN_NAME = "hst_paye";

  /*---------- Clés étrangères ---------*/

  public static final String FK_ID_USER_COLUMN_NAME = "use_id";

  public static final String FK_ID_PANIER_COLUMN_NAME = "pan_id";
}

package uber.repository.client;

public class ClientConstantsSQL
{
  private ClientConstantsSQL()
  {
    throw new IllegalStateException("Utility class");
  }

  /*---------- Table ---------*/
  public static final String TABLE_NAME = "t_client_cli";

  /*---------- Colonne ---------*/
  public static final String ID_COLUMN_NAME = "cli_id";

  public static final String NOM_COLUMN_NAME = "cli_nom";

  public static final String PRENOM_COLUMN_NAME = "cli_prenom";

  public static final String NUMERO_TELEPHONE_COLUMN_NAME = "cli_numero_tel";

  public static final String ADRESSE_COLUMN_NAME = "cli_adresse";

  public static final String MAIL_COLUMN_NAME = "cli_email";

}

package uber.repository.user;

public class UserConstantsSQL
{
  private UserConstantsSQL()
  {
    throw new IllegalStateException("Utility class");
  }

  /*---------- Table ---------*/
  public static final String TABLE_NAME = "t_users_use";

  /*---------- Colonne ---------*/
  public static final String ID_COLUMN_NAME = "use_id";

  public static final String MAIL_COLUMN_NAME = "use_email";

  public static final String PASSWORD_COLOMN_NAME = "use_password";

  public static final String USERNAME_COLOMN_NAME = "use_username";

  public static final String ADRESSE_COLUMN_NAME = "use_adresse";

  public static final String NOM_COLUMN_NAME = "use_nom";

  public static final String PRENOM_COLUMN_NAME = "use_prenom";

  public static final String NUMERO_TELEPHONE_COLUMN_NAME = "use_telephone";

}

package uber.repository.commentaire;

public class CommentaireConstantSQL
{
  /*---------- Table ---------*/
  public static final String TABLE_NAME = "t_commentaire_com";

  /*---------- Colonne ---------*/
  public static final String ID_COLUMN_NAME = "com_id";

  public static final String TEXTE_COLUMN_NAME = "com_texte";

  /*---------- Clés étrangères ---------*/

  public static final String FK_ID_USER_COLUMN_NAME = "use_id";

  public static final String FK_ID_RESTO_COLUMN_NAME = "rst_id";

}

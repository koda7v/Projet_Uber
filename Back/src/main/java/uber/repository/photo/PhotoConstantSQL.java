package uber.repository.photo;

public class PhotoConstantSQL
{
  private PhotoConstantSQL()
  {
    throw new IllegalStateException("Utility class");
  }

  /*---------- Table ---------*/
  public static final String TABLE_NAME = "t_photo_pht";

  /*---------- Colonne ---------*/
  public static final String ID_COLUMN_NAME = "pht_id";

  public static final String PHOTO_COLUMN_NAME = "pht_photo";

  public static final String COMMENTAIRE_COLUMN_NAME = "pht_commentaire";

}

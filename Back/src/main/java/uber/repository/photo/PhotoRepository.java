package uber.repository.photo;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import uber.model.Photo;

public interface PhotoRepository extends PagingAndSortingRepository<Photo, Long>
{
  @Override
  public List<Photo> findAll();

  @Modifying
  @Query("INSERT INTO " + PhotoConstantSQL.TABLE_NAME + " ( " + PhotoConstantSQL.ID_COLUMN_NAME + " , "
      + PhotoConstantSQL.NAME_COLUMN_NAME + " , " + PhotoConstantSQL.BLOB_COLUMN_NAME + " , "
      + PhotoConstantSQL.COMMENTAIRE_COLUMN_NAME + " )  VALUES ( :id, :name, :photo , :commentaire )")
  void addPhoto(@Param("id") Long id, @Param("name") String name, @Param("photo") byte[] photo,
      @Param("commentaire") String commentaire);

  @Modifying
  @Query("UPDATE " + PhotoConstantSQL.TABLE_NAME + " SET " + PhotoConstantSQL.NAME_COLUMN_NAME + " = :name, "
      + PhotoConstantSQL.BLOB_COLUMN_NAME + " = :blob, " + PhotoConstantSQL.COMMENTAIRE_COLUMN_NAME
      + " = :commentaire WHERE " + PhotoConstantSQL.ID_COLUMN_NAME + " = :id")
  void updatePhoto(@Param("id") Long id, @Param("blob") byte[] blob, @Param("name") String name,
      @Param("commentaire") String commentaire);

}

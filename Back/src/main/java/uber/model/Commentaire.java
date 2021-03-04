package uber.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import uber.repository.commentaire.CommentaireConstantSQL;

@Table(CommentaireConstantSQL.TABLE_NAME)
public class Commentaire
{

  @Id
  @Column(CommentaireConstantSQL.ID_COLUMN_NAME)
  protected Long id;

  @NotEmpty
  @Column(CommentaireConstantSQL.TEXTE_COLUMN_NAME)
  protected String text;

  @Column(CommentaireConstantSQL.FK_ID_USER_COLUMN_NAME)
  protected Long idUser;

  @Column(CommentaireConstantSQL.FK_ID_RESTO_COLUMN_NAME)
  protected Long idResto;

  /**
   * 
   * @param id
   * @param text
   * @param idUser
   * @param idPlat
   */
  public Commentaire(Long id, String text, Long idUser, Long idResto)
  {
    this.id = id;
    this.text = text;
    this.idUser = idUser;
    this.idResto = idResto;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getText()
  {
    return text;
  }

  public void setText(String text)
  {
    this.text = text;
  }

  public Long getIdUser()
  {
    return idUser;
  }

  public void setIdUser(Long idUser)
  {
    this.idUser = idUser;
  }

  public Long getIdResto()
  {
    return idResto;
  }

  public void setIResto(Long idResto)
  {
    this.idResto = idResto;
  }

}

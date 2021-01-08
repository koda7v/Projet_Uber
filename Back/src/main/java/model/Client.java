package model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import repository.client.ClientConstantsSQL;

@Table(ClientConstantsSQL.TABLE_NAME)
public class Client
{

  @Id
  @Column(ClientConstantsSQL.ID_COLUMN_NAME)
  protected Long id;

  @NotEmpty
  @Column(ClientConstantsSQL.NOM_COLUMN_NAME)
  protected String nom;

  @NotEmpty
  @Column(ClientConstantsSQL.PRENOM_COLUMN_NAME)
  protected String prenom;

  @NotEmpty
  @Column(ClientConstantsSQL.ADRESSE_COLUMN_NAME)
  protected String adresse;

  @NotEmpty
  @Column(ClientConstantsSQL.MAIL_COLUMN_NAME)
  protected String email;

  @NotEmpty(message = "Votre numero de telephone doit avoir des chiffres")
  @Size(min = 10, max = 12, message = "Votre numero de telephone doit avoir entre 10 et 12 chiffres")
  @Column(ClientConstantsSQL.NUMERO_TELEPHONE_COLUMN_NAME)
  protected String telephone;

  /**
   * 
   * @param id
   * @param nom
   * @param prenom
   * @param adresse
   * @param email
   * @param telephone
   */
  public Client(Long id, String nom, String prenom, String adresse, String email, String telephone)
  {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.adresse = adresse;
    this.email = email;
    this.telephone = telephone;
  }

  /**
   * 
   * @param nom
   * @param prenom
   * @param adresse
   * @param email
   * @param telephone
   */
  public Client(String nom, String prenom, String adresse, String email, String telephone)
  {
    this.nom = nom;
    this.prenom = prenom;
    this.adresse = adresse;
    this.email = email;
    this.telephone = telephone;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getNom()
  {
    return nom;
  }

  public void setNom(String nom)
  {
    this.nom = nom;
  }

  public String getPrenom()
  {
    return prenom;
  }

  public void setPrenom(String prenom)
  {
    this.prenom = prenom;
  }

  public String getAdresse()
  {
    return adresse;
  }

  public void setAdresse(String adresse)
  {
    this.adresse = adresse;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getTelephone()
  {
    return telephone;
  }

  public void setTelephone(String telephone)
  {
    this.telephone = telephone;
  }

}

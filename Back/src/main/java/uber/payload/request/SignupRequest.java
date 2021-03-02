package uber.payload.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.relational.core.mapping.Column;

import uber.repository.user.UserConstantsSQL;

public class SignupRequest
{

  private Set<String> role;

  @NotBlank
  @Size(max = 20)
  @Column(UserConstantsSQL.USERNAME_COLOMN_NAME)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  @Column(UserConstantsSQL.MAIL_COLUMN_NAME)
  private String email;

  @NotBlank
  @Size(max = 120)
  @Column(UserConstantsSQL.PASSWORD_COLOMN_NAME)
  private String password;

  @NotEmpty
  @Column(UserConstantsSQL.NOM_COLUMN_NAME)
  protected String nom;

  @NotEmpty
  @Column(UserConstantsSQL.PRENOM_COLUMN_NAME)
  protected String prenom;

  @NotEmpty
  @Column(UserConstantsSQL.ADRESSE_COLUMN_NAME)
  protected String adresse;

  @NotEmpty(message = "Votre numero de telephone doit avoir des chiffres")
  @Size(min = 10, max = 12, message = "Votre numero de telephone doit avoir entre 10 et 12 chiffres")
  @Column(UserConstantsSQL.NUMERO_TELEPHONE_COLUMN_NAME)
  protected String telephone;

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public Set<String> getRole()
  {
    return this.role;
  }

  public void setRole(Set<String> role)
  {
    this.role = role;
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

  public String getTelephone()
  {
    return telephone;
  }

  public void setTelephone(String telephone)
  {
    this.telephone = telephone;
  }

}

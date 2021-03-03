package uber.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import uber.repository.user.UserConstantsSQL;

@Entity
@Table(name = UserConstantsSQL.TABLE_NAME, uniqueConstraints = {
    @UniqueConstraint(columnNames = UserConstantsSQL.USERNAME_COLOMN_NAME),
    @UniqueConstraint(columnNames = UserConstantsSQL.MAIL_COLUMN_NAME) })
public class User
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = UserConstantsSQL.ID_COLUMN_NAME)
  private Long id;

  @NotBlank
  @Size(max = 20)
  @Column(name = UserConstantsSQL.USERNAME_COLOMN_NAME)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  @Column(name = UserConstantsSQL.MAIL_COLUMN_NAME)
  private String email;

  @NotBlank
  @Size(max = 120)
  @Column(name = UserConstantsSQL.PASSWORD_COLOMN_NAME)
  private String password;

  @NotEmpty
  @Column(name = UserConstantsSQL.NOM_COLUMN_NAME)
  protected String nom;

  @NotEmpty
  @Column(name = UserConstantsSQL.PRENOM_COLUMN_NAME)
  protected String prenom;

  @NotEmpty
  @Column(name = UserConstantsSQL.ADRESSE_COLUMN_NAME)
  protected String adresse;

  @NotEmpty(message = "Votre numero de telephone doit avoir des chiffres")
  @Size(min = 10, max = 12, message = "Votre numero de telephone doit avoir entre 10 et 12 chiffres")
  @Column(name = UserConstantsSQL.NUMERO_TELEPHONE_COLUMN_NAME)
  protected String telephone;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "t_user_roles_use", joinColumns = @JoinColumn(name = "use_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
  private Set<Role> roles = new HashSet<>();

  public User()
  {}

  /**
   * 
   * @param id
   * @param username
   * @param email
   * @param password
   * @param nom
   * @param prenom
   * @param adresse
   * @param telephone
   */
  public User(Long id, String username, String email, String password, String nom, String prenom, String adresse,
              String telephone)
  {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.nom = nom;
    this.prenom = prenom;
    this.adresse = adresse;
    this.telephone = telephone;
  }

  /**
   * 
   * @param username
   * @param email
   * @param password
   * @param nom
   * @param prenom
   * @param adresse
   * @param telephone
   */
  public User(String username, String email, String password, String nom, String prenom, String adresse,
              String telephone)
  {
    this.username = username;
    this.email = email;
    this.password = password;
    this.nom = nom;
    this.prenom = prenom;
    this.adresse = adresse;
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

  public Set<Role> getRoles()
  {
    return roles;
  }

  public void setRoles(Set<Role> roles)
  {
    this.roles = roles;
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

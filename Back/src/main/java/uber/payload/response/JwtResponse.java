package uber.payload.response;

import java.util.List;

public class JwtResponse
{
  private String token;
  private String type = "Bearer";
  private Long id;
  private String username;
  private String email;
  protected String adresse;
  protected String nom;
  protected String prenom;
  protected String telephone;
  private List<String> roles;

  public JwtResponse(String accessToken, Long id, String username, String email, String adresse, String nom,
                     String prenom, String telephone, List<String> roles)
  {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = roles;
    this.adresse = adresse;
    this.nom = nom;
    this.prenom = prenom;
    this.telephone = telephone;

  }

  public String getAccessToken()
  {
    return token;
  }

  public void setAccessToken(String accessToken)
  {
    this.token = accessToken;
  }

  public String getTokenType()
  {
    return type;
  }

  public void setTokenType(String tokenType)
  {
    this.type = tokenType;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public List<String> getRoles()
  {
    return roles;
  }

  public String getAdresse()
  {
    return adresse;
  }

  public void setAdresse(String adresse)
  {
    this.adresse = adresse;
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

  public String getTelephone()
  {
    return telephone;
  }

  public void setTelephone(String telephone)
  {
    this.telephone = telephone;
  }

}

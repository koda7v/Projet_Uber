package uber.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

public class Plat {

	@Id
	protected Long id;

	@NotEmpty
	protected String nom;

	@NotEmpty
	protected String description;
	protected Integer prix;

	public Plat(Long id, String nom, String description, Integer prix) {
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

}

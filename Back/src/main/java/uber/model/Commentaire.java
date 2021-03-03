package uber.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

public class Commentaire
{

	@Id
	protected Long id;
	
	@NotEmpty
	protected String text;
	
	@Id
	protected Long idUser;
	
	@Id
	protected Long idPlat;
	
	/**
	 * 
	 * @param id
	 * @param text
	 * @param idUser
	 * @param idPlat
	 */
	public Commentaire(Long id, String text, Long idUser, Long idPlat) {
		this.id = id;
		this.text = text;
		this.idUser = idUser;
		this.idPlat = idPlat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdPlat() {
		return idPlat;
	}

	public void setIdPlat(Long idPlat) {
		this.idPlat = idPlat;
	}
	
	
	
	
}

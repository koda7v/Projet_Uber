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
	protected Long idClient;
	
	@Id
	protected Long idPlat;
	
	/**
	 * 
	 * @param id
	 * @param text
	 * @param idClient
	 * @param idPlat
	 */
	public Commentaire(Long id, String text, Long idClient, Long idPlat) {
		this.id = id;
		this.text = text;
		this.idClient = idClient;
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

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public Long getIdPlat() {
		return idPlat;
	}

	public void setIdPlat(Long idPlat) {
		this.idPlat = idPlat;
	}
	
	
	
	
}

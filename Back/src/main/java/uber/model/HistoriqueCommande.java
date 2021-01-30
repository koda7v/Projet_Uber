package uber.model;

import org.springframework.data.annotation.Id;

public class HistoriqueCommande {

	@Id
	protected Long id;

	@Id
	protected Long idClient;

	public HistoriqueCommande(Long id, Long idClient) {
		this.id = id;
		this.idClient = idClient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

}

package uber.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

public class Panier {
	@Id
	protected Long id;

	protected Long total;

	protected Date date;

	@Id
	protected Long idClient;

	protected Set<Plat> plats;

	public Panier(Long id, Long total, Date date, Long idClient) {
		this.id = id;
		this.total = total;
		this.date = date;
		this.idClient = idClient;
		this.plats = new HashSet<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public Set<Plat> getPlats() {
		return plats;
	}

	public void setPlats(Set<Plat> plats) {
		this.plats = plats;
	}

}

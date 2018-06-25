package model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprunt")
public class Emprunt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "date_debut")
	private LocalDateTime date_debut;

	@Column(name = "date_fin")
	private LocalDateTime date_fin;

	@Column(name = "delai")
	private int delai;

	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;

	@ManyToMany(mappedBy = "emprunts")
	private Set<Livre> livres;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the date_debut
	 */
	public LocalDateTime getDate_debut() {
		return date_debut;
	}

	/**
	 * @param date_debut
	 *            the date_debut to set
	 */
	public void setDate_debut(LocalDateTime date_debut) {
		this.date_debut = date_debut;
	}

	/**
	 * @return the date_fin
	 */
	public LocalDateTime getDate_fin() {
		return date_fin;
	}

	/**
	 * @param date_fin
	 *            the date_fin to set
	 */
	public void setDate_fin(LocalDateTime date_fin) {
		this.date_fin = date_fin;
	}

	/**
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
	}

	/**
	 * @param delai
	 *            the delai to set
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}

	/**
	 * @param livres
	 *            the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", delai=" + delai + "]";
	}
}

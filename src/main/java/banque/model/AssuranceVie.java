package banque.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("assurance_vie")
public class AssuranceVie extends Compte {
	@Column(name = "date_fin")
	private LocalDate dateFin;

	@Column(name = "taux")
	private double taux;

	/**
	 * @return the datefin
	 */
	public LocalDate getDatefin() {
		return dateFin;
	}

	/**
	 * @param datefin
	 *            the datefin to set
	 */
	public void setDatefin(LocalDate datefin) {
		this.dateFin = datefin;
	}

	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**
	 * @param taux
	 *            the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}
}

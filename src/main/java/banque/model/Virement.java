package banque.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("virement")
public class Virement extends Operation {
	private String beneficiare;

	/**
	 * @return the beneficiare
	 */
	public String getBeneficiare() {
		return beneficiare;
	}

	/**
	 * @param beneficiare the beneficiare to set
	 */
	public void setBeneficiare(String beneficiare) {
		this.beneficiare = beneficiare;
	}
}

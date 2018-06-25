package banque.app;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.model.Adresse;
import banque.model.AssuranceVie;
import banque.model.Banque;
import banque.model.Client;
import banque.model.Virement;

public class TestJpa {

	public static void main(String[] args) {
		// initialisation du manager
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			Adresse adresse = new Adresse();
			adresse.setCodePostal(44800);
			adresse.setNumero(6);
			adresse.setRue("Chemin de la Chatterie");
			adresse.setVille("Saint-Herblain");
			
			Banque banque = new Banque();
			banque.setNom("LCL");
			em.persist(banque);
			
			Client client = new Client();
			client.setAdresse(adresse);
			client.setBanque(banque);
			client.setDateNaissance(LocalDate.of(1994, 9, 2));
			client.setNom("Abitbol");
			client.setPrenom("Georges");
			em.persist(client);
			
			AssuranceVie compte = new AssuranceVie();
			compte.setNumero("55555");
			compte.setSolde(1000);
			compte.setTaux(1.1);
			compte.setDatefin(LocalDate.of(2030, 12, 31));
			em.persist(compte);
			
			Virement operation = new Virement();
			operation.setCompte(compte);
			operation.setDate(LocalDateTime.of(2018, 6, 25, 17, 29));
			operation.setMontant(720);
			operation.setMotif("les bonnes thunes olala");
			operation.setBeneficiare("Morsay Truand 2 la Galère");
			em.persist(operation);
			
			et.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture des ressources
			em.close();
			entityManagerFactory.close();
		}

	}

}

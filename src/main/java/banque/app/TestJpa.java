package banque.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.model.Adresse;
import banque.model.AssuranceVie;
import banque.model.Banque;
import banque.model.Client;
import banque.model.LivretA;
import banque.model.Operation;
import banque.model.Virement;

public class TestJpa {

	public static void main(String[] args) {
		// initialisation du manager
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			Adresse adresse1 = new Adresse();
			adresse1.setCodePostal(44800);
			adresse1.setNumero(6);
			adresse1.setRue("Chemin de la Chatterie");
			adresse1.setVille("Saint-Herblain");

			Adresse adresse2 = new Adresse();
			adresse2.setCodePostal(44800);
			adresse2.setNumero(45);
			adresse2.setRue("Impasse des Grosses Saucisses");
			adresse2.setVille("Saint-Herblain");

			Banque banque = new Banque();
			banque.setNom("LCL");
			em.persist(banque);

			Client client1 = new Client();
			client1.setAdresse(adresse1);
			client1.setBanque(banque);
			client1.setDateNaissance(LocalDate.of(1994, 9, 2));
			client1.setNom("Abitbol");
			client1.setPrenom("Georges");
			em.persist(client1);

			Client client2 = new Client();
			client2.setAdresse(adresse2);
			client2.setBanque(banque);
			client2.setDateNaissance(LocalDate.of(1995, 7, 25));
			client2.setNom("Le Nervuré");
			client2.setPrenom("Pierre-Aymeric");
			em.persist(client2);

			Set<Client> clients1 = new HashSet<Client>();
			clients1.add(client1);
			clients1.add(client2);
			
			Set<Client> clients2 = new HashSet<Client>();
			clients2.add(client2);

			AssuranceVie compteAssur = new AssuranceVie();
			compteAssur.setNumero("55555");
			compteAssur.setSolde(1000);
			compteAssur.setTaux(1.1);
			compteAssur.setDatefin(LocalDate.of(2030, 12, 31));
			compteAssur.setClients(clients1);
			em.persist(compteAssur);
			
			LivretA livretA = new LivretA();
			livretA.setNumero("15976");
			livretA.setSolde(1374.23);
			livretA.setTaux(0.75);
			livretA.setClients(clients2);
			em.persist(livretA);

			Virement operation1 = new Virement();
			operation1.setCompte(compteAssur);
			operation1.setDate(LocalDateTime.of(2018, 6, 25, 17, 29));
			operation1.setMontant(720);
			operation1.setMotif("les bonnes thunes olala");
			operation1.setBeneficiare("Morsay Truand 2 la Galère");
			em.persist(operation1);
			
			Virement operation2 = new Virement();
			operation2.setCompte(compteAssur);
			operation2.setDate(LocalDateTime.of(2018, 6, 26, 9, 52));
			operation2.setMontant(39.99);
			operation2.setMotif("des sous");
			operation2.setBeneficiare("Fond d'Investissement des Orfèvres Nantais");
			em.persist(operation2);
			
			Operation operation3 = new Operation();
			operation3.setCompte(compteAssur);
			operation3.setDate(LocalDateTime.of(2018, 6, 26, 9, 54));
			operation3.setMontant(106.21);
			operation3.setMotif("yolo");
			em.persist(operation3);

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

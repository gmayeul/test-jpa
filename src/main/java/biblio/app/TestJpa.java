package biblio.app;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import biblio.model.Emprunt;
import biblio.model.Livre;

public class TestJpa {

	public static void main(String[] args) {
		// initialisation du manager
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();

		try {
			// TP 2
			Livre l1 = em.find(Livre.class, 3);
			if (l1 != null)
				System.out.println(l1.toString());

			TypedQuery<Livre> query1 = em.createQuery("SELECT l FROM Livre l WHERE l.titre=:titre", Livre.class);
			query1.setParameter("titre", "Germinal");
			Livre l2 = query1.getResultList().get(0);
			if (l2 != null)
				System.out.println(l2.toString());

			// TP 3
			TypedQuery<Livre> query2 = em
					.createQuery("SELECT l FROM Livre l JOIN l.emprunts e WHERE e.id=:id", Livre.class);
			query2.setParameter("id", 4);
			for (Livre l : query2.getResultList())
				if (l != null)
					System.out.println(l.toString());
			
			TypedQuery<Emprunt> query3 = em.createQuery("SELECT e FROM Emprunt e WHERE e.client.id = :id", Emprunt.class);
			query3.setParameter("id", 3);
			for (Emprunt e : query3.getResultList())
				if (e != null)
					System.out.println(e.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture des ressources
			em.close();
			entityManagerFactory.close();
		}

	}

}

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Livre;

public class TestJpa {

	public static void main(String[] args) {
		// initialisation du manager
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();

		try {
			// test find()
			Livre l1 = em.find(Livre.class, 3);
			if (l1 != null)
				System.out.println(l1.toString());

			// test TypedQuery
			TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l WHERE l.titre='Germinal'", Livre.class);
			Livre l2 = query.getResultList().get(0);
			if (l2 != null)
				System.out.println(l2.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture des ressources
			em.close();
			entityManagerFactory.close();
		}

	}

}

package lab.dao.jpa;

import lab.dao.CountryDao;
import lab.model.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

	@Override
	public void save(Country country) {
		EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(country);

        transaction.commit();
        if (em != null) {
			em.close();
		}
	}

	@Override
	public List<Country> getAllCountries() {
//	TODO: Implement it
		return null	;
	}// getAllcountries()

	@Override
	public Country getCountryByName(String name) {
//		TODO: Implement it

		return null;
	}

}

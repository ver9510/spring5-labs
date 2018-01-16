package lab.dao.jpa;

import lombok.Setter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Setter(onMethod = @__(@PersistenceUnit))
public class AbstractJpaDao {
	protected EntityManagerFactory emf;

}
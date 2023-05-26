package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Students;

public class StudentDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transcation = manager.getTransaction();

	public void save(Students student) {
		transcation.begin();
		manager.persist(student);
		transcation.commit();
	}

	public Students fetch(String email) {

		List<Students> list = manager.createQuery("select x from Students x where email=?1").setParameter(1, email)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Students fetch(long mobile) {

		List<Students> list = manager.createQuery("select x from Students x where phone=?1").setParameter(1, mobile)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
	public List<Students> fetch() {

		List<Students> list = manager.createQuery("select x from Students x ").getResultList();
		return list;
		}

	public void delete(int id) {
		transcation.begin();
		manager.remove(manager.find(Students.class, id));
		transcation.commit();
	}
	}
	

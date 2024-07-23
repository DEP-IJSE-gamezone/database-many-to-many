package lk.ijse.dep12.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.relationship.entity.Course;
import lk.ijse.dep12.relationship.jpa.JpaUtil;

public class Many2ManyDemo1 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {

            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Course math = new Course("E001", "Math", "12 months");
                Course english = new Course("E002", "English", "10 months");

                em.persist(math);
                em.persist(english);
                tx.commit();
            } catch (Throwable e) {
                e.printStackTrace();
                tx.rollback();
            }

        }
    }
}

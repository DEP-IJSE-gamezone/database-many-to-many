package lk.ijse.dep12.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.relationship.entity.Course;
import lk.ijse.dep12.relationship.entity.Student;
import lk.ijse.dep12.relationship.jpa.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;

public class Many2ManyDemo2 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {

            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();


                Student s001 = new Student("S001", "Dilini", "Matara", "041-12333432", Date.valueOf(LocalDate.now()));
                Student s002 = new Student("S002", "Malith", "Colombo", "011-12333432", Date.valueOf(LocalDate.now()));

                em.persist(s001);
                em.persist(s002);
                tx.commit();
            } catch (Throwable e) {
                e.printStackTrace();
                tx.rollback();
            }

        }
    }
}

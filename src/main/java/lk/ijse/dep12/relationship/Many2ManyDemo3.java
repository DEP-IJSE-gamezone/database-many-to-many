package lk.ijse.dep12.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.relationship.entity.Course;
import lk.ijse.dep12.relationship.entity.Student;
import lk.ijse.dep12.relationship.entity.StudentCourse;
import lk.ijse.dep12.relationship.entity.StudentCoursePK;
import lk.ijse.dep12.relationship.jpa.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;

public class Many2ManyDemo3 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {

            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                Course english = em.find(Course.class, "E001");
                Student dilini = em.find(Student.class, "S001");
                StudentCoursePK studentCourceDetail = new StudentCoursePK(dilini.getId(), english.getCode());
                StudentCourse studentCourse = new StudentCourse(studentCourceDetail, "Mr.Saman", Date.valueOf(LocalDate.now()));


                em.persist(studentCourse);
                tx.commit();
            } catch (Throwable e) {
                e.printStackTrace();
                tx.rollback();
            }

        }
    }
}

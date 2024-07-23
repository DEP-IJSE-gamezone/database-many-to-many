package lk.ijse.dep12.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_course")
public class StudentCourse implements Serializable {

    @EmbeddedId
    private StudentCoursePK studentCoursePK;
    @Column(name = "registered_by")
    private String registerdBy;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id", updatable = false,insertable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_code",referencedColumnName = "code", updatable = false,insertable = false)
    private Course course;

    public StudentCourse(StudentCoursePK studentCoursePK, String registerdBy, Date date) {
        this.studentCoursePK = studentCoursePK;
        this.registerdBy = registerdBy;
        this.date = date;
    }

    public StudentCourse(Student student, Course course, String registerdBy, Date date) {
        this.studentCoursePK = new StudentCoursePK(student.getId(),course.getCode());
        this.registerdBy = registerdBy;
        this.date = date;
    }
}

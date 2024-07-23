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
//    private String studentId;
//    private String courseCode;
    @EmbeddedId
    private StudentCoursePK studentCoursePK;
    private String registerdBy;
    private Date date;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseCode")
    private Course course;

    public StudentCourse( Student student,Course course, String registerdBy, Date date) {
        this.studentCoursePK = new StudentCoursePK(student.getId(),course.getCode());
        this.registerdBy = registerdBy;
        this.date = date;
    }
}

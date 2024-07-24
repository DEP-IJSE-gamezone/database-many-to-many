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
@IdClass(StudentCoursePK.class)
public class StudentCourse implements Serializable {
    @Id
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    @ManyToOne
    private Student student;
    @Id
    @JoinColumn(name = "course_code",referencedColumnName = "code")
    @ManyToOne
    private Course course;
    @Column(name = "registered_by")
    private String registeredBy;
    private Date date;



}

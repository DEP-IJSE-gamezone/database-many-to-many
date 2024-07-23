package lk.ijse.dep12.relationship.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class StudentCoursePK implements Serializable {
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "course_code")
    private String courseCode;

}

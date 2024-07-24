package lk.ijse.dep12.relationship.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "course")
@ToString(exclude = "studentCourses")
public class Course implements Serializable {
    @Id
    private String code;
    private String name;
    private String duration;

    @OneToMany(mappedBy = "course",cascade = {CascadeType.DETACH,CascadeType.PERSIST})
    @Setter(AccessLevel.NONE)
    private List<StudentCourse> studentCourses=new ArrayList<>();

    public Course(String code, String name, String duration) {
        this.code = code;
        this.name = name;
        this.duration = duration;
    }

    public Course(String code, String name, String duration, List<StudentCourse> studentCourses) {
      if(!studentCourses.isEmpty() && studentCourses !=null){
          studentCourses.stream().filter(st->st.getCourse()==null).forEach(st->st.setCourse(this));
          studentCourses.forEach(st->{
              if (st.getCourse() != this)
                  throw new IllegalStateException("The student is already enrolled to the %s course".formatted(st.getCourse().getName()));
          });
      }
        this.code = code;
        this.name = name;
        this.duration = duration;
        this.studentCourses = studentCourses;
    }
}

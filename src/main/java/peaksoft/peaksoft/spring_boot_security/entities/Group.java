package peaksoft.peaksoft.spring_boot_security.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "date_of_start")
    private String dateOfStart;
    @Column(name = "date_of_finish")
    private String dateOfFinish;

    //    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
//    @JoinColumn(name = "course_id")
//    private Course course;
    @Transient
    private Long courseId;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "groups_courses",
            joinColumns = @JoinColumn(name = "groups_id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id"))
    private List<Course> courses;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Student> students;

}

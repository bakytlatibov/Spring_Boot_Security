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

    @Transient
    private Long courseId;
@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST})
@JoinTable(name = "groups_courses",
        joinColumns = @JoinColumn(name = "groups_id"),
        inverseJoinColumns = @JoinColumn(name = "courses_id"))
    private List<Course> courses;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "group")
    private List<Student> students;

}

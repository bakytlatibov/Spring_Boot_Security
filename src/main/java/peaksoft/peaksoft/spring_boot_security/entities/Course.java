package peaksoft.peaksoft.spring_boot_security.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "duration_month")
    private String durationMonth;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "company_id")
    private Company company;
    @Transient
    private Long companyId;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "courses")

    List<Group> groups;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "course")
    private Teacher teacher;


}

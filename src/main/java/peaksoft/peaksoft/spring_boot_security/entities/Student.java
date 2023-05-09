package peaksoft.peaksoft.spring_boot_security.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "study_format")
    @Enumerated
    private StudyFormation studyFormation;
    @ManyToOne(cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "group_id")
    private Group group;
    @Transient
    private Long groupId;
}

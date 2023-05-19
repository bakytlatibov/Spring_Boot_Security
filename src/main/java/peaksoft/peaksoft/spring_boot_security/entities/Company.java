package peaksoft.peaksoft.spring_boot_security.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "company_name",unique = true)
    private String companyName;
    @Column(name = "located_country")
    private String locatedCountry;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    private List<Course> course;


}

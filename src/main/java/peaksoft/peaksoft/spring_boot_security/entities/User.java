package peaksoft.peaksoft.spring_boot_security.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @Column(name ="user_name")
    private String username;
    @Column(name ="last_name")
    private String lastName;
    private int age;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
@Transient
    private String roleName;
}

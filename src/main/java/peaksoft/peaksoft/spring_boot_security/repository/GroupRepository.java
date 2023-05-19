package peaksoft.peaksoft.spring_boot_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.peaksoft.spring_boot_security.entities.Group;
import peaksoft.peaksoft.spring_boot_security.entities.Student;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
    @Query("select s from Student s where s.firstName=?1")
    public List<Student> getStudentByName(String name);






}

package peaksoft.peaksoft.spring_boot_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.peaksoft.spring_boot_security.entities.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query(" select s from Student s join Group g ON s.group.id = g.id join g.courses c join Company com ON c.company.id = com.id where com.id=:id")
    List<Student> getStudentByCompany(@Param("id") Long companyId);

    @Query("select s from Student s where s.firstName=?1")
    List<Student> getStudentByName(String name);

    @Query("select s from Student s join Group g ON s.group.id = g.id join g.courses c join Teacher t ON c.teacher.id = t.id where t.id=:id")
    List<Student> getStudentsByTeacher(@Param("id") Long teacherId);
}
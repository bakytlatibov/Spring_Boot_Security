package peaksoft.peaksoft.spring_boot_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.peaksoft.spring_boot_security.entities.Student;
import peaksoft.peaksoft.spring_boot_security.entities.Teacher;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
//    @Query("select s from Student s join Group g ON s.group.id = g.id join g.courses c join Teacher t ON c.teacher.id = t.id where t.id=:id")
//    public List<Student> getStudentsByTeacher(@Param("id") Long teacherId);
//}
}
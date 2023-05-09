package peaksoft.peaksoft.spring_boot_security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.peaksoft.spring_boot_security.entities.Course;
import peaksoft.peaksoft.spring_boot_security.entities.Teacher;
import peaksoft.peaksoft.spring_boot_security.repository.CourseRepository;
import peaksoft.peaksoft.spring_boot_security.repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;


    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();

    }

    public Teacher getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId).get();
    }

    public void addTeacher(Long teacherId, Teacher teacher) {
        Teacher teacher1 = teacherRepository.findById(teacherId).get();
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        teacherRepository.save(teacher1);
    }

    public void updateTeacher(Long teacherId, Long courseId, Teacher teacher) {
        Course course = courseRepository.findById(courseId).get();
        Teacher teacher1 = teacherRepository.findById(teacherId).get();
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        course.setTeacher(teacher1);
        teacher1.setCourse(course);
        teacherRepository.save(teacher1);

    }

    public void deleteTeacher(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

}

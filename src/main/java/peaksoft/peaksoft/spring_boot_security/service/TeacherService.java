package peaksoft.peaksoft.spring_boot_security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.peaksoft.spring_boot_security.entities.Course;
import peaksoft.peaksoft.spring_boot_security.entities.Student;
import peaksoft.peaksoft.spring_boot_security.entities.Teacher;
import peaksoft.peaksoft.spring_boot_security.repository.CourseRepository;
import peaksoft.peaksoft.spring_boot_security.repository.TeacherRepository;

import java.util.List;
import java.util.Objects;

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

    public void addTeacher(Long courseId, Teacher teacher) {
        Course course = courseRepository.findById(courseId).get();
        teacher.setCourse(course);
        teacherRepository.save(teacher);

    }


    public void updateTeacher(Long teacherId, Long courseId, Teacher teacher) {
        Teacher teacher1 = teacherRepository.findById(teacherId).get();
        Course course = courseRepository.findById(courseId).get();
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setCourse(course);
        course.setTeacher(teacher1);
        teacherRepository.save(teacher1);

    }

    public void deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacher.setCourse(null);
        teacherRepository.delete(teacher);

//        if (teacher.getCourse() == null){
//            teacherRepository.delete(teacher);
//        }
//        teacher.setCourse(null);
//        teacherRepository.delete(teacher);

    }


}

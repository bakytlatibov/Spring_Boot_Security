package peaksoft.peaksoft.spring_boot_security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.peaksoft.spring_boot_security.entities.Company;
import peaksoft.peaksoft.spring_boot_security.entities.Course;
import peaksoft.peaksoft.spring_boot_security.repository.CompanyRepository;
import peaksoft.peaksoft.spring_boot_security.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public void addCourse(Long companyId, Course course) {
        Company company = companyRepository.findById(companyId).get();
        course.setCompany(company);
        courseRepository.save(course);

    }

    public Course getCurseById(Long id) {
        return courseRepository.findById(id).get();
    }

    public void updateCourse(Long companyId, Long courseId, Course course) {
        Course course1 = courseRepository.findById(courseId).get();
        course1.setCourseName(course.getCourseName());
        course1.setDurationMonth(course.getDurationMonth());
        Company company = companyRepository.findById(companyId).get();
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        company.setCourse(courses);
        course1.setCompany(company);
        courseRepository.save(course1);


    }

    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }


}


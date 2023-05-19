package peaksoft.peaksoft.spring_boot_security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.peaksoft.spring_boot_security.entities.Course;
import peaksoft.peaksoft.spring_boot_security.entities.Group;
import peaksoft.peaksoft.spring_boot_security.entities.Student;
import peaksoft.peaksoft.spring_boot_security.repository.CourseRepository;
import peaksoft.peaksoft.spring_boot_security.repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class GroupService {

    private final GroupRepository groupRepository;

    private final CourseRepository courseRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public void addGroup(Long courseId, Group group) {
        Course course = courseRepository.findById(courseId).get();
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        List<Group> groups = new ArrayList<>();
        groups.add(group);
        course.setGroups(groups);
        group.setCourses(courses);
        groupRepository.save(group);

    }

    public Group getGroupById(Long id) {
        return groupRepository.findById(id).get();
    }

    public void updateGroup(Long groupId, Long courseId, Group group) {
        Group group1 = groupRepository.findById(groupId).get();
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setDateOfFinish(group.getDateOfFinish());
        Course course = courseRepository.findById(courseId).get();
        List<Group> groups = new ArrayList<>();
        groups.add(group1);
        course.setGroups(groups);
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        group1.setCourses(courses);
        groupRepository.save(group1);
    }

    public void deleteGroup(Group group) {
        groupRepository.delete(group);


    }
    public List<Student> getStudentByName(String name){
        return groupRepository.getStudentByName(name);
    }

}

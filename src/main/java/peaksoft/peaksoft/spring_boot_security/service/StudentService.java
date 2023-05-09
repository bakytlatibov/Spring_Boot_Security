package peaksoft.peaksoft.spring_boot_security.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.peaksoft.spring_boot_security.entities.Group;
import peaksoft.peaksoft.spring_boot_security.entities.Student;
import peaksoft.peaksoft.spring_boot_security.repository.GroupRepository;
import peaksoft.peaksoft.spring_boot_security.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GroupRepository groupRepository;

  public   List<Student> getAllStudents(){
      return   studentRepository.findAll();
    }

   public Student getStudentById(Long studentId){
      return   studentRepository.findById(studentId).get();
    }

   public void addStudent(Long groupId,Student student){
        Group group=groupRepository.findById(groupId).get();
        student.setGroup(group);
        studentRepository.save(student);
    }

  public   void updateStudent(Long groupId,Long studentId, Student student){
        Group group=groupRepository.findById(groupId).get();
        Student student1=studentRepository.findById(studentId).get();
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setStudyFormation(student.getStudyFormation());
        List<Student>students=new ArrayList<>();
        students.add(student1);
        group.setStudents(students);
        student1.setGroup(group);
        studentRepository.save(student1);
    }

   public void deleteStudent(Student student){
        studentRepository.delete(student);
    }


    public List<Student> getStudentByCompany(Long companyId){
       return studentRepository.getStudentByCompany(companyId);
    }
  public   List<Student>getStudentByName(String name){
      return null;

  }
 public    List<Student>getStudentsByTeacher(Long teacherId){
      return null;
 }

}

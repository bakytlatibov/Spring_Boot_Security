package peaksoft.peaksoft.spring_boot_security.controller1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.peaksoft.spring_boot_security.entities.Group;
import peaksoft.peaksoft.spring_boot_security.entities.Student;
import peaksoft.peaksoft.spring_boot_security.service.GroupService;
import peaksoft.peaksoft.spring_boot_security.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor

public class StudentController {
    private final StudentService service;
    private final GroupService groupService;

    @ModelAttribute("groupList")
    public List<Group> getGroupList() {
        return groupService.getAllGroups();

    }

    @GetMapping()
    public String getAllStudents(Model model) {
        List<Student> students = service.getAllStudents();
        model.addAttribute("students", students);
        return "student/students";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student/addStudent";
    }

    @PostMapping("saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.addStudent(student.getGroupId(), student);
        return "redirect:/students";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "student/updateStudent";
    }

    @RequestMapping(value = "{id}",method = {RequestMethod.PATCH,RequestMethod.GET})
    public String saveUpdate(@PathVariable("id") Long id, @ModelAttribute("students") Student student) {
        service.updateStudent(student.getGroupId(), id, student);
        return "redirect:/students";
    }
    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteStudent(@PathVariable("id") Long id) {
      Student student=service.getStudentById(id);
      service.deleteStudent(student);
        return "redirect:/students";
}}






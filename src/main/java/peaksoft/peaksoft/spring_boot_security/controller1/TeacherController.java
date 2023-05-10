package peaksoft.peaksoft.spring_boot_security.controller1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.peaksoft.spring_boot_security.entities.Course;
import peaksoft.peaksoft.spring_boot_security.entities.Student;
import peaksoft.peaksoft.spring_boot_security.entities.Teacher;
import peaksoft.peaksoft.spring_boot_security.service.CourseService;
import peaksoft.peaksoft.spring_boot_security.service.StudentService;
import peaksoft.peaksoft.spring_boot_security.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final CourseService courseService;

    @ModelAttribute("courses")
    public List<Course> getCourses() {
        return courseService.getAllCourse();

    }

    @GetMapping()
    public String getAllTeachers(Model model) {
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teacher/teachers";

    }

    @GetMapping("/addTeacher")
    public String addTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teacher/addTeacher";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.addTeacher(teacher.getCourseId(), teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/update/{id}")
    public String updateTeacher(@PathVariable("id") Long id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("updateTeacher", teacher);
        return "teacher/updateTeacher";

    }

    @RequestMapping(value = "{id}",method = {RequestMethod.PATCH,RequestMethod.GET})
    public String saveUpdateTeacher(@PathVariable("id") Long id, @ModelAttribute("teacher") Teacher teacher) {
        teacherService.updateTeacher(id, teacher.getCourseId(), teacher);
        return "redirect:/teachers";
    }

    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteTeacher(@PathVariable("id") Long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        teacherService.deleteTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/students/{teacherId}")
    public String getStudentsByTeacher(@PathVariable("teacherId") Long teacherId, Model model) {
        List<Student> studentList = studentService.getStudentsByTeacher(teacherId);
        model.addAttribute("studentList", studentList);
        model.addAttribute("count", studentList.size());
        return "teacher/students";
    }
}

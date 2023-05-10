package peaksoft.peaksoft.spring_boot_security.controller1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.peaksoft.spring_boot_security.entities.Company;
import peaksoft.peaksoft.spring_boot_security.entities.Course;
import peaksoft.peaksoft.spring_boot_security.service.CompanyService;
import peaksoft.peaksoft.spring_boot_security.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final CompanyService companyService;


    @ModelAttribute("companyList")
    public List<Company> getCompanyList() {
        return companyService.getAllCompanies();

    }

    @GetMapping
    public String getAllCourses(Model model) {
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("courses", courses);
        return "courses/courses";


    }

    @GetMapping("/addCourse")
    public String addCourses(Model model) {
        model.addAttribute("course", new Course());
        return "courses/addCourse";

    }

    @PostMapping("saveCourse")

    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.addCourse(course.getCompanyId(), course);

        return "redirect:/courses";


    }

    @GetMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") Long id, Model model) {
        Course course = courseService.getCurseById(id);
        model.addAttribute("updateCourse", course);
        return "courses/updateCourse";
    }

    @RequestMapping(value = "{id}",method = {RequestMethod.PATCH,RequestMethod.GET})
    public String saveUpdateCourse(@PathVariable("id") Long id, @ModelAttribute("course") Course course) {
        courseService.updateCourse(course.getCompanyId(), id, course);
        return "redirect:/courses";
    }

    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteCourse(@PathVariable("id") Long id) {
        Course course1 = courseService.getCurseById(id);
        courseService.deleteCourse(course1);
        return "redirect:/courses";


    }

}
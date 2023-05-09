package peaksoft.peaksoft.spring_boot_security.controller1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.peaksoft.spring_boot_security.entities.Company;
import peaksoft.peaksoft.spring_boot_security.entities.Student;
import peaksoft.peaksoft.spring_boot_security.repository.CompanyRepository;
import peaksoft.peaksoft.spring_boot_security.service.CompanyService;
import peaksoft.peaksoft.spring_boot_security.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final StudentService studentService;
    private final CompanyService companyService;
    private final CompanyRepository companyRepository;


    @GetMapping
    public String getAllCompanies(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "company/companies";
    }

    @GetMapping("/addCompany")
    public String addCompany(Model model) {
        model.addAttribute("company", new Company());
        return "company/addCompany";
    }


    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.addCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("update/{id}")
    private String updateCompany(@PathVariable("id") Long id, Model model) {
        Company company = companyService.getCompanyById(id);
        model.addAttribute("updateCompany", company);
        return "company/updateCompany";
    }

    @RequestMapping( value = "{id}",method = {RequestMethod.PATCH,RequestMethod.GET})
    public String saveUpdateCompany(@PathVariable("id") Long id, @ModelAttribute("company") Company company) {
        companyService.updateCompany(id, company);
//        companyRepository.saveAndFlush(company);
        return "redirect:/companies";
    }

    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteCompany(@PathVariable("id") Long id) {
        Company company = companyService.getCompanyById(id);
        companyService.deleteCompany(company);
        return "redirect:/companies";

    }


    @GetMapping("/students/{companyId}")
    public String getStudentsByCompany(@PathVariable("companyId") Long companyId, Model model) {
        List<Student> studentList = studentService.getStudentByCompany(companyId);
        model.addAttribute("studentList", studentList);
        model.addAttribute("count", studentList.size());
        return "company/students";
    }


}

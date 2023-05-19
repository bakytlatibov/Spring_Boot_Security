package peaksoft.peaksoft.spring_boot_security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.peaksoft.spring_boot_security.entities.Company;
import peaksoft.peaksoft.spring_boot_security.repository.CompanyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {


    private final CompanyRepository companyRepository;

  public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

   public void addCompany(Company company) {
        companyRepository.save(company);
    }

   public Company getCompanyById(Long id) {
        return companyRepository.findById(id).get();
    }

   public void updateCompany(Long id, Company company) {
        Company company1 = companyRepository.findById(id).get();
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        companyRepository.save(company1);
    }

  public  void deleteCompany(Company company) {
        companyRepository.delete(company);
    }


}

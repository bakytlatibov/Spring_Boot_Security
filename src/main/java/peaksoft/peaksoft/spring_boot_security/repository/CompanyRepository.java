package peaksoft.peaksoft.spring_boot_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.peaksoft.spring_boot_security.entities.Company;
@Repository
public interface CompanyRepository  extends JpaRepository<Company,Long> {

}

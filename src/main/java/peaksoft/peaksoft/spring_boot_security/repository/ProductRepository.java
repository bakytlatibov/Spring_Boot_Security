package peaksoft.peaksoft.spring_boot_security.repository;

import peaksoft.peaksoft.spring_boot_security.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}

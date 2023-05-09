package peaksoft.peaksoft.spring_boot_security.service;

import peaksoft.peaksoft.spring_boot_security.entity.Product;
import peaksoft.peaksoft.spring_boot_security.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public void delete(Product product) {
        productRepository.delete(product);

    }


}

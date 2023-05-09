package peaksoft.peaksoft.spring_boot_security.controller1;

import peaksoft.peaksoft.spring_boot_security.entity.Product;
import peaksoft.peaksoft.spring_boot_security.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")

public class ProductController {
    private final ProductService productService;
    @GetMapping()
    public String getAllProducts(Model model){
        List<Product>products=   productService.getAllProducts();
model.addAttribute("products",products);
return "products";

    }
    @GetMapping("/new")
    public String addProduct(Model model){
        model.addAttribute("product",new Product());
        return "save_product";
    }
    @PostMapping("/save_product")
    public String saveProduct(@ModelAttribute("product")Product product){
        productService.addProduct(product);
        return "redirect:/";
    }

}

package redis.app.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.app.model.Product;
import redis.app.service.ProductService;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @PatchMapping("/{id}")
    public void sellProduct(@PathVariable Long id, @RequestParam  Long amount) {
        productService.sellProduct(id, amount);
    }
}

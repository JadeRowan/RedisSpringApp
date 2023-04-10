package product.description.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import product.description.service.model.ProductDescription;
import product.description.service.service.ProductDescriptionService;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductDescriptionController {

  private ProductDescriptionService productDescriptionService;

  @GetMapping("/{id}/description")
  public ProductDescription getProductDescription(@PathVariable Long id) {
    return productDescriptionService.getProductDescription(id);
  }
}

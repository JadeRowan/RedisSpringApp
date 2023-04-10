package product.amount.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import product.amount.service.service.ProductAmountService;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductAmountController {

  private ProductAmountService productAmountService;

  @GetMapping("/{id}/amount")
  public Long getProductAmount(@PathVariable Long id) {
    return productAmountService.getProductAmount(id);
  }

  @PostMapping("/{id}/amount")
  public void decreaseProductAmount(@PathVariable Long id, @RequestParam Long amount) {
    productAmountService.decreaseAmount(id, amount);
  }
}

package product.review.service.controller;

import lombok.AllArgsConstructor;
import org.bson.Document;
import org.bson.json.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import product.review.service.service.ProductReviewService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductReviewController {

  private ProductReviewService productReviewService;

  @GetMapping("/{id}/reviews")
  public List<String> getProductReviews(@PathVariable Long id) {
    return productReviewService.getProductReviews(id);
  }
}

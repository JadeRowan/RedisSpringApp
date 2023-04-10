package product.review.service.service;

import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;
import product.review.service.dao.ProductReviewDao;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductReviewService {

  private ProductReviewDao productReviewDao;

  public List<String> getProductReviews(Long id) {
    return productReviewDao.findById(id);
  }
}

package product.description.service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import product.description.service.dao.ProductDescriptionDao;
import product.description.service.model.ProductDescription;

@Service
@AllArgsConstructor
public class ProductDescriptionService {

  private ProductDescriptionDao productDescriptionDao;

  public ProductDescription getProductDescription(Long id) {
    return productDescriptionDao.findById(id).orElseThrow();
  }
}

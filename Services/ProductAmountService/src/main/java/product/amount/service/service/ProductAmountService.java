package product.amount.service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import product.amount.service.dao.ProductAmountDao;

@Service
@AllArgsConstructor
public class ProductAmountService {

  private ProductAmountDao productAmountDao;

  public Long getProductAmount(Long id) {
    return productAmountDao.getReferenceById(id).getAmount();
  }

  public void decreaseAmount(Long id, Long amount) {
    productAmountDao.reduce(id, amount);
  }
}

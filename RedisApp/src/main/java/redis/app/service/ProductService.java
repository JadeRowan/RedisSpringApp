package redis.app.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;
import redis.app.RequestManager;
import redis.app.model.Product;
import redis.app.model.ProductDescription;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService {

  private RequestManager requestManager;
  private Cache cache;


  public Product findProductById(Long id) {
    log.info("Searching for product with id: " + id);
    Product product = cache.get(id, Product.class);
    if (Objects.isNull(product)) {
      log.info("No product to be found, collecting new one");
      product = collectProduct(id);
      log.info("Product collected saving to cache");
      cache.put(id, product);
    }
    return product;
  }

  private Product collectProduct(Long id) {
    Long amount = requestManager.getProductAmount(id);
    ProductDescription description = requestManager.getProductDescription(id);
    List<String> reviews = requestManager.getProductReviews(id);
    return new Product(id, amount, description, reviews);
  }

  public void sellProduct(Long productId, Long amount) {
    requestManager.sellProduct(productId, amount);
    log.info("Product data updated, invalidating the record");
    cache.evict(productId);
  }
}

package redis.app.dao;


import java.util.List;


import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import redis.app.entyty.Product;

@Repository
public class ProductDao {

    private static final String HASH_KEY = "Product";
    private RedisTemplate template;

    public ProductDao(RedisTemplate template) {
        this.template = template;
    }

    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(Long id) {
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    public Long deleteProduct(Long id) {
        return template.opsForHash().delete(HASH_KEY, id);
    }
}

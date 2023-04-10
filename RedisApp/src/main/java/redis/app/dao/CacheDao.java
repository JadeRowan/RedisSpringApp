package redis.app.dao;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import redis.app.model.Product;

import java.util.Objects;
import java.util.Optional;

@Repository
@Slf4j
public class CacheDao {

    private static final String CACHE_NAME = "products";
    private Cache cache;

    public CacheDao(RedisCacheManager cacheManager) {
        this.cache = cacheManager.getCache(CACHE_NAME);;
    }

    public Product save(Product product) {
        cache.put(product.getId(), product);
        return product;
    }

    public Optional<Product> findProduct(Long id) {
        log.info("Searching product by id: " + id);
        Cache.ValueWrapper valueWrapper = cache.get(id);
        if (valueWrapper != null) {
            return Optional.ofNullable((Product) valueWrapper.get());
        }
        log.info("valueWrapper is null");
        return Optional.empty();
    }

    public void invalidateRecord(Long id) {
        cache.evict(id);
    }
}

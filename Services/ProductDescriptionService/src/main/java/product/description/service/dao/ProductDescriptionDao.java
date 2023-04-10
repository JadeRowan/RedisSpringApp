package product.description.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.description.service.model.ProductDescription;

@Repository
public interface ProductDescriptionDao  extends JpaRepository<ProductDescription, Long> {
}

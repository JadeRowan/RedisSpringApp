package product.amount.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import product.amount.service.model.ProductAmount;

@Repository
public interface ProductAmountDao extends JpaRepository<ProductAmount, Long> {

  @Modifying
  @Transactional
  @Query("UPDATE ProductAmount pa SET pa.amount = pa.amount - :amount WHERE pa.productId = :productId")
  void reduce(@Param("productId") Long productId, @Param("amount") Long amount);

}

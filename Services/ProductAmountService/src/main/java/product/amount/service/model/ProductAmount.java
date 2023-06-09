package product.amount.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product_amount")
public class ProductAmount {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "product_id", nullable = false)
  private Long productId;

  private Long amount;
}

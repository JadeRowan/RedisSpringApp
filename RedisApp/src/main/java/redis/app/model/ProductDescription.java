package redis.app.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDescription implements Serializable {
  private Long productId;
  private String name;
  private String category;
  private String description;
  private Double price;
}

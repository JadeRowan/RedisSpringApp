package redis.app;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import redis.app.model.ProductDescription;


import java.util.List;

@Component
@AllArgsConstructor
public class RequestManager {

  private RestTemplate restTemplate;

  public Long getProductAmount(Long productId) {
    String url = UriComponentsBuilder.fromUriString("http://localhost:8081/product/{id}/amount")
        .buildAndExpand(productId)
        .toUriString();
    return restTemplate.getForObject(url, Long.class);
  }

  public void sellProduct(Long productId, Long amount) {
    String url = UriComponentsBuilder.fromUriString("http://localhost:8081/product/{id}/amount")
        .buildAndExpand(productId)
        .toUriString();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<>("", headers);

    restTemplate.exchange(url + "?amount=" + amount, HttpMethod.POST, entity, Void.class);

  }

  public ProductDescription getProductDescription(Long productId) {
    String url = UriComponentsBuilder.fromUriString("http://localhost:8082/product/{id}/description")
        .buildAndExpand(productId)
        .toUriString();
    return restTemplate.getForObject(url, ProductDescription.class);
  }

  public List<String> getProductReviews(Long productId) {
    String url = UriComponentsBuilder.fromUriString("http://localhost:8083/product/{id}/reviews")
        .buildAndExpand(productId)
        .toUriString();
    return restTemplate.getForObject(url, List.class);
  }
}

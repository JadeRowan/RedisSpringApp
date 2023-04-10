package product.review.service.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class ProductReviewDao {

  private MongoClient mongoClient;

  public List<String> findById(Long id) {
    MongoDatabase database = mongoClient.getDatabase("mongodb_product_data");
    MongoCollection<Document> collection = database.getCollection("product_review");

    Bson filter = Filters.eq("product_id", id);
    FindIterable<Document> projection = collection.find(filter);
    List<String> reviews = new ArrayList<>();
    projection.forEach(document -> reviews.add(document.toJson()));

    return reviews;
  }

  //  @PostConstruct
  public void init() {
    MongoDatabase database = mongoClient.getDatabase("mongodb_product_data");
    MongoCollection<Document> collection = database.getCollection("product_review");

    List<Document> documents = new ArrayList<Document>();
    documents.add(new Document("product_id", 1).append("reviewDate", "2022-01-01T00:00:00Z").append("content", "This is a great product!").append("author", "John Doe"));
    documents.add(new Document("product_id", 1).append("reviewDate", "2022-01-02T00:00:00Z").append("content", "I am very satisfied with this product.").append("rating", 4));
    documents.add(new Document("product_id", 1).append("reviewDate", "2022-01-03T00:00:00Z").append("content", "This product is just okay.").append("author", "Jane Smith").append("rating", 2));
    documents.add(new Document("product_id", 2).append("reviewDate", "2022-01-04T00:00:00Z").append("content", "I love this product!").append("author", "Sam Jones").append("rating", 5));
    documents.add(new Document("product_id", 2).append("reviewDate", "2022-01-05T00:00:00Z").append("content", "This product exceeded my expectations.").append("rating", 4));
    documents.add(new Document("product_id", 2).append("reviewDate", "2022-01-06T00:00:00Z").append("content", "This product is not what I was hoping for.").append("author", "Kate Lee").append("rating", 2));
    documents.add(new Document("product_id", 3).append("reviewDate", "2022-01-07T00:00:00Z").append("content", "I highly recommend this product!").append("author", "Mike Brown").append("rating", 5));
    documents.add(new Document("product_id", 3).append("reviewDate", "2022-01-08T00:00:00Z").append("content", "This product is a great value for the price.").append("rating", 4));
    documents.add(new Document("product_id", 3).append("reviewDate", "2022-01-09T00:00:00Z").append("content", "I was disappointed with this product.").append("author", "Sarah Johnson").append("rating", 2));
    documents.add(new Document("product_id", 4).append("reviewDate", "2022-01-10T00:00:00Z").append("content", "This product is amazing!").append("author", "Tom Smith").append("rating", 5));
    documents.add(new Document("product_id", 4).append("reviewDate", "2022-01-11T00:00:00Z").append("content", "I was pleasantly surprised by this product.").append("rating", 4));
    documents.add(new Document("product_id", 4).append("reviewDate", "2022-01-12T00:00:00Z").append("content", "This product didn't meet my expectations.").append("author", "Anna Lee").append("rating", 2));
    documents.add(new Document("product_id", 5).append("reviewDate", "2022-02-10T00:00:00Z").append("content", "This product is amazing!").append("author", "Gregory Wane").append("rating", 5));
    documents.add(new Document("product_id", 5).append("reviewDate", "2022-02-11T00:00:00Z").append("content", "I was pleasantly surprised by this product.").append("rating", 4));
    documents.add(new Document("product_id", 5).append("reviewDate", "2022-02-12T00:00:00Z").append("content", "This product didn't meet my expectations.").append("author", "May Stone").append("rating", 2));

    collection.insertMany(documents);
  }
}
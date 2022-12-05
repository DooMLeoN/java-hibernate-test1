package dao;

import model.Product;

import java.util.Optional;

public interface ProductDao {
    Product save(Product product);

    Optional<Product> get(Long id);
}

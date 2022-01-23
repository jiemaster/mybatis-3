package demo.dao;

import demo.domain.Product;

import java.util.List;

public interface ProductMapper {

    Product find(long id);

    List<Product> findByName(String name);

    Long save(Product product);

}

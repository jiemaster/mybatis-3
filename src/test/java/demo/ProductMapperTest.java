package demo;


import demo.dao.ProductMapper;
import demo.domain.Product;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductMapperTest {

    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setDescription("product description");
        product.setId(-1L);
        product.setPrice(BigDecimal.TEN);
        product.setName("productName");

        Long execute = DaoUtils.execute(sqlSession -> {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            return productMapper.save(product);
        });

        System.out.println("create successfully!");
    }

}

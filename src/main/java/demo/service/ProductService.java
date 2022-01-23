package demo.service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import demo.DaoUtils;
import demo.dao.ProductMapper;
import demo.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {

    public long createProduct(final Product product) {
        // check
        Preconditions.checkArgument(product != null, "product is null");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(product.getName()), "product name is empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(product.getDescription()), "product description is empty");
        Preconditions.checkArgument(product.getPrice().compareTo(BigDecimal.ZERO) > 0, "price <= error");

        return DaoUtils.execute(sqlSession -> {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            return productMapper.save(product);
        });
    }

    public Product find(long productId) {
        Preconditions.checkArgument(productId > 0, "product id error");
        return DaoUtils.execute(sqlSession -> {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            return productMapper.find(productId);
        });
    }

    public List<Product> find(String productName) {
        Preconditions.checkArgument(Strings.isNullOrEmpty(productName), "product id error");
        return DaoUtils.execute(sqlSession -> {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            return productMapper.findByName(productName);
        });
    }



}

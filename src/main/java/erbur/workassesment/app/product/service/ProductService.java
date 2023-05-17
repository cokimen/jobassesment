package erbur.workassesment.app.product.service;

import erbur.workassesment.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;




public interface ProductService {
    public Product create(Product p);
    public Page<Product> listProducts(int page, int size);

    public Product getProduct(Long productId);

    public Product update(Product product);

    public Product remove(Long productId);
}

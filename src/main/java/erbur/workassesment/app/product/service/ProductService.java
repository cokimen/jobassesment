package erbur.workassesment.app.product.service;

import erbur.workassesment.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;




public interface ProductService {
    public Product create(Product p);
    public ArrayList<Product> listProducts();

    public Product getProduct(Long productId);

    public Product update(Product product);

    public Product remove(Long productId);
}

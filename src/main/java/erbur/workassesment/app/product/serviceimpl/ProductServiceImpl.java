package erbur.workassesment.app.product.serviceimpl;

import erbur.workassesment.app.product.repository.ProductRepository;
import erbur.workassesment.app.product.service.ProductService;
import erbur.workassesment.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;




@Component("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @Override
    public Product create(Product p) {
        return productRepository.save(p);
    }

    @Override
    public ArrayList<Product> listProducts() {
        return (ArrayList<Product>) productRepository.findAll();
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId).get();
    }


    @Transactional
    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Product remove(Long productId) {
        Product product = productRepository.findById(productId).get();
        productRepository.deleteById(productId);
        return product;
    }
}

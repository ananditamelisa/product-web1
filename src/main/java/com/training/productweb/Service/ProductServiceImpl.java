package com.training.productweb.Service;

import com.training.productweb.Product;
import com.training.productweb.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> byId = productRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }else{
            return null;
        }
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        Optional<Product> byId = productRepository.findById(product.getProductID());
        if(byId.isPresent()){
            return productRepository.save(product);
        }else{
            return null;
        }
    }

    @Override
    public Product delete(Long id) {
        Optional<Product> byId = productRepository.findById(id);
        if(byId.isPresent()){
            Product p = byId.get();
            productRepository.delete(byId.get());
            return p;
        }else{
            return null;
        }
    }
}

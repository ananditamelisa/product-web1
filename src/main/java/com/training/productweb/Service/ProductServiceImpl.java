package com.training.productweb.Service;

import com.training.productweb.Product;
import com.training.productweb.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
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

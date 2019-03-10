package com.training.productweb.Service;

import com.training.productweb.Product;

import java.util.List;

public interface ProductService {
    Product create (Product product);
    Product findById (Long id);
    List<Product> findAll();
    Product update (Product product);
    Product delete (Long id);
}

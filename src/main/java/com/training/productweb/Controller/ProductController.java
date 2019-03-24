package com.training.productweb.Controller;

import com.training.productweb.Product;
import com.training.productweb.Service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){this.productService = productService;}

    @CrossOrigin
    @RequestMapping(
            value = "/products",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product create(@RequestBody Product m){
        return productService.create(m);
    }

    @CrossOrigin
    @RequestMapping(
            value = "/products/{idProduct}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product findById (@PathVariable("idProduct") Long id){
        return productService.findById(id);
    }

    @CrossOrigin
    @RequestMapping(
            value = "/products",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Product> findAll(){
        return productService.findAll();
    }

    @CrossOrigin
    @RequestMapping(
            value = "/products/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product update (@RequestBody  Product m){
        return productService.update(m);
    }

    @CrossOrigin
    @RequestMapping(
            value = "/products/delete/{idProduct}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product delete (@PathVariable("idProduct") Long id){
        return productService.delete(id);
    }
}

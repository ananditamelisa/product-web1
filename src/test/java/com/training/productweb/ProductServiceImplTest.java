package com.training.productweb;

import com.training.productweb.Repository.ProductRepository;
import com.training.productweb.Service.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

public class ProductServiceImplTest {
    private ProductServiceImpl productService;
    private ProductRepository productRepository;

    @Before
    public void setUp() throws  Exception{
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    public void testSave(){
        Product product = new Product(1L, "Dongeng Anak", "Fables and Animal Story",
                "Ibu Diah", "zzz", 60000, 12);
        Mockito.when(productRepository.save(product)).thenReturn(product);
        Product result = productService.create(product);
        Assert.assertTrue(result!=null);
        Assert.assertTrue(product.getProductID().equals(result.getProductID()));

        Mockito.verify(productRepository, Mockito.times(1)).save(product);
    }

    @Test
    public void testFindById(){
        Product product = new Product(1L, "Dongeng Anak", "Fables and Animal Story",
                "Ibu Diah", "zzz", 60000, 12);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Mockito.when(productRepository.findById(2L)).thenReturn(Optional.empty());

        Product result1 = productService.findById(1L);
        Assert.assertTrue(result1!=null);

        Product result2 = productService.findById(2L);
        Assert.assertTrue(result2==null);

        Mockito.verify(productRepository, Mockito.times(1)).findById(1L);
        Mockito.verify(productRepository, Mockito.times(1)).findById(2L);
    }
}

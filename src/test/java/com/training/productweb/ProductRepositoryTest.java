package com.training.productweb;

import com.training.productweb.Repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    private Product p1,p2,p3,create1,create2,create3,updated;

    @Before
    public void setUp()throws Exception{
        p1 = new Product();
        p1.setName("Rinso");
        p1.setCategory("Cleanser");
        p1.setPrice(15000);
        p1.setStock(500);
        create1 = productRepository.save(p1);

        p2 = new Product();
        p2.setName("Muji Notebook");
        p2.setCategory("Stationery");
        p2.setPrice(35000);
        p2.setStock(100);
        create2 = productRepository.save(p2);

        p3 = new Product();
        p3.setName("Samsung Galaxy S10");
        p3.setCategory("Electronic");
        p3.setPrice(39000000);
        p3.setStock(5);
        create3 = productRepository.save(p3);
    }
    @Test
    public void testFindAll(){
        Assert.assertTrue("harusnya total member ada 3", productRepository.findAll().size()==3);
    }
    @Test
    public void testCreate(){
        Assert.assertTrue("yg di insert harus sama dgn yg di create", p1 == create1);

    }
    @Test
    public void testUpdate(){
        p2 = new Product();
        p2.setProductID(create2.getProductID());
        p2.setName("Snappy Notebook");
        p2.setCategory("Stationery");
        p2.setPrice(35000);
        p2.setStock(100);
        updated = productRepository.save(p2);

        Assert.assertTrue("member harus terupdate",
                updated.getProductID()==create2.getProductID());

    }

    @Test
    public void testFindById(){
        Optional<Product> byId = productRepository.findById(create3.getProductID());
        if(byId.isPresent()){
            Assert.assertTrue("harusnya member m3 bisa ketemu",
                    byId.get().getName().equals("Samsung Galaxy S10"));
        }
    }

    @Test
    public void testDelete(){
        productRepository.deleteById(create2.getProductID());
        Assert.assertFalse("harusnya skrg id dari create2 udh gaada",
                productRepository.existsById(create2.getProductID()));
    }

}

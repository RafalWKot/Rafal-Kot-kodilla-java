package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    ProductDao productDao;

    @Autowired
    InvoiceDao invoiceDao;

    @Autowired
    ItemDao itemDao;

    @Test
    public void testInvoiceDaoSave(){

        //Given
        List<Product> products = Arrays.asList(new Product("Pen"), new Product("Pencil"));

        List<Item> items = new ArrayList<>();
        items.add(new Item(products.get(0), BigDecimal.valueOf(10.0), 2, BigDecimal.valueOf(20.0)));
        items.add(new Item(products.get(0), BigDecimal.valueOf(15.0), 3, BigDecimal.valueOf(45.0)));
        items.add(new Item(products.get(1), BigDecimal.valueOf(5.0), 1, BigDecimal.valueOf(5)));

        Invoice invoice = new Invoice("001/2018");
        invoice.setItems(items);
        items.forEach(t->t.setInvoice(invoice));

        //When;
        invoiceDao.save(invoice);

        //Then
        Assert.assertEquals(true, invoiceDao.existsByNumber("001/2018"));
        Assert.assertEquals(true, productDao.existsProductByName("Pen"));
        Assert.assertEquals(true, itemDao.existsItemByValue(BigDecimal.valueOf(45.0)));

        //CleanUp
        try {
            invoiceDao.delete(invoice);
        }
        catch (Exception e){

        }
    }
}

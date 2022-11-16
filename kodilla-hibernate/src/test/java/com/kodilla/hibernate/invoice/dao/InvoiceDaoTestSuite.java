package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {
    private static final String INVOICE_NUMBER = "12345";
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ProductDao productDao;


    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Witcher 3");
        Product product2 = new Product("Witcher 2");

        Item item1 = new Item(product1, new BigDecimal("30"), 2);
        Item item2 = new Item(product2, new BigDecimal("20"), 2);

        Invoice invoice = new Invoice(INVOICE_NUMBER);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        List<Product> productsInObject = invoice.getItems().stream()
                .map(Item::getProduct).toList();
        List<Product> productDaoAll = (List<Product>) productDao.findAll();

        List<Item> itemsInObject = invoice.getItems();
        List<Item> itemDaoAll = (List<Item>) itemDao.findAll();

        //Then && ClenUp
        try {
            assertEquals(productsInObject.size(), productDaoAll.size());
            assertEquals(itemsInObject.size(), itemDaoAll.size());
        } catch (Exception e) {
            //Do nothing
        } finally {
            invoiceDao.deleteById(id);
            for (int i=itemsInObject.size()-1; i>=0; i--) {
                itemDao.deleteById(itemsInObject.get(i).getId());
            }
        }
    }
}

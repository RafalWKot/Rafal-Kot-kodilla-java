package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Transactional
@Repository
public interface ItemDao extends CrudRepository<Item, Integer> {
    Boolean existsItemByValue(BigDecimal bigDecimal);
}

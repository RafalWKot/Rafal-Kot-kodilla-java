package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Product;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

    Boolean existsProductByName(String name);
}

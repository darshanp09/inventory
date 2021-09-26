package com.io.management.dao.impl;

import com.io.management.dao.ProductDao;
import com.io.management.model.Product;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;


    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.find(Product.class, id);
        session.flush();
        return product;
    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from products ORDER BY quantitySold DESC");
        List<Product> products = query.list();
        session.flush();

        return products;
    }

    public void deleteProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
        session.flush();
    }

    public List<Product> getProductBySearch(String productSearchName) {
        Session session = sessionFactory.getCurrentSession();
        String sql1 = "SELECT * from products p where p.productName LIKE :productSearchName";
        SQLQuery query = session.createSQLQuery(sql1);
        query.addEntity(Product.class);
        query.setParameter("productSearchName", "%" + productSearchName + "%");
        List<Product> results = query.list();
        return results;

    }
}

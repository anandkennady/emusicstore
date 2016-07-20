package com.niit.shop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shop.dao.ProductDao;
import com.niit.shop.model.Product;


@Repository("ProductDao")
@Transactional
public class ProductDaoImpl implements ProductDao {


    @Autowired
    private SessionFactory sessionFactory;

    public Product getProductById (int id){
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();

        return product;
    }
    @SuppressWarnings(value = { "unchecked" })
    public List<Product> getProductList(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> productList = query.list();
        session.flush();

        return productList;
    }

    public void addProduct (Product product){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void editProduct (Product product){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void deleteProduct (Product product){
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }

} // The End of Class;


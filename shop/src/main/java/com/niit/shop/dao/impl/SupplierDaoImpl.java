package com.niit.shop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shop.dao.SupplierDao;
import com.niit.shop.model.Supplier;



public class SupplierDaoImpl implements SupplierDao {


    @Autowired
    private SessionFactory sessionFactory;

    public Supplier getSupplierById (int supplierid){
        Session session = sessionFactory.getCurrentSession();
        Supplier supplier = (Supplier) session.get(Supplier.class, supplierid);
        session.flush();

        return supplier;
    }
    @SuppressWarnings(value = { "unchecked" })
    public List<Supplier> getSupplierList(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Supplier");
        List<Supplier> supplierList = query.list();
        session.flush();

        return supplierList;
    }

    public void addSupplier (Supplier supplier){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(supplier);
        session.flush();
    }

    public void editSupplier (Supplier supplier){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(supplier);
        session.flush();
    }

    public void deleteSupplier (Supplier supplier){
        Session session = sessionFactory.getCurrentSession();
        session.delete(supplier);
        session.flush();
    }

} // The End of Class;



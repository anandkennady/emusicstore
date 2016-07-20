package com.niit.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.shop.dao.SupplierDao;
import com.niit.shop.model.Supplier;
import com.niit.shop.service.SupplierService;
@Service
public class SupplierServiceImpl implements SupplierService {

	

	    @Autowired
	    private SupplierDao supplierDao;

	    public Supplier getSupplierById(int supplierId){
	        return supplierDao.getSupplierById(supplierId);
	    }

	    public List<Supplier> getSupplierList(){
	        return supplierDao.getSupplierList();
	    }

	    public void addSupplier(Supplier supplier){
	    	supplierDao.addSupplier(supplier);
	    }

	    public void editSupplier(Supplier supplier){
	    	supplierDao.editSupplier(supplier);
	    }

	    public void deleteSupplier(Supplier supplier){
	    	supplierDao.deleteSupplier(supplier);
	    }


	} // The End of Class;

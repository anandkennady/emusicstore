package com.niit.shop.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.shop.dao.SupplierDao;
import com.niit.shop.model.Supplier;



@Controller
@RequestMapping("/supplier")
public class SupplierController {

	  @Autowired
	    private SupplierDao supplierDao;

	    @RequestMapping("/supplierList/all")
	    public String getSuppliers(Model model){
	        List<Supplier> suppliers = supplierDao.getSupplierList();
	        model.addAttribute("suppliers", suppliers);

	        return "supplierList";
	    }

	    @RequestMapping("/viewSupplier/{supplierid}")
	    public String viewSupplier(@PathVariable int supplierid, Model model) throws IOException{
	    	Supplier supplier = supplierDao.getSupplierById(supplierid);
	        model.addAttribute("supplier", supplier);

	        return "viewSupplier";
	    }

	    @RequestMapping("/supplierList")
	    public String getSupplierByCategory(@RequestParam("searchCondition") String searchCondition, Model model){
	        List<Supplier> suppliers = supplierDao.getSupplierList();
	        model.addAttribute("suppliers", suppliers);
	        model.addAttribute("searchCondition", searchCondition);

	        return "supplierList";
	    }

	} // The End of Class;

package com.niit.shop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shop.dao.CustomerDao;
import com.niit.shop.dao.ProductDao;
import com.niit.shop.model.Customer;
import com.niit.shop.model.Product;



@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CustomerDao customerDao;
   

    @RequestMapping
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model){
        List<Product> products = productDao.getProductList();
        model.addAttribute("products", products);

        return "productInventory";
    }

    @RequestMapping("/customer")
    public String customerManagerment(Model model){

        List<Customer> customerList = customerDao.getAllCustomers();
        model.addAttribute("customerList", customerList);

        return "customerManagement";
    }



} // The End of Class;

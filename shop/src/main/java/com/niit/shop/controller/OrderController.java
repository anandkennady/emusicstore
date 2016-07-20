package com.niit.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shop.dao.CartDao;
import com.niit.shop.dao.CustomerOrderDao;
import com.niit.shop.model.Cart;
import com.niit.shop.model.Customer;
import com.niit.shop.model.CustomerOrder;



@Controller
public class OrderController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId){
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartDao.getCartById(cartId);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customer.setShippingAddress(customer.getShippingAddress());

        customerOrderDao.addCustomerOrder(customerOrder);

        return "redirect:/checkout?cartId=" + cartId;

    }

} // The End of Class;


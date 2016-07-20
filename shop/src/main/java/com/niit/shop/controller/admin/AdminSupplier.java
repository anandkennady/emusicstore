package com.niit.shop.controller.admin;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.niit.shop.dao.SupplierDao;
import com.niit.shop.model.Supplier;



public class AdminSupplier {

	private Path path;

    @Autowired
    private SupplierDao supplierDao;

    @RequestMapping("/supplier/addSupplier")
    public String addSupplier(Model model){
    	Supplier supplier = new Supplier();
    	supplier.setSupplierproduct("001");
    	supplier.setSuppliername("new");
    	supplier.setSuppliername("active");

        model.addAttribute("supplier",supplier);

        return "addSupplier";
    }

    @RequestMapping(value="/supplier/addSupplier", method = RequestMethod.POST)
    public String addSupplierPost(@Valid @ModelAttribute("supplier") Supplier supplier, BindingResult result, HttpServletRequest request){

        if(result.hasErrors()){
            return "addSupplier";
        }

        supplierDao.addSupplier(supplier);

        MultipartFile supplierImage = supplier.getSupplierImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + supplier.getSupplierid() + ".png");

        if(supplierImage != null && !supplierImage.isEmpty()){
            try {
            	supplierImage.transferTo(new File(path.toString()));
            } catch (Exception ex){
                ex.printStackTrace();
                throw new RuntimeException("supplier image saving failed", ex);
            }
        }

        return "redirect:/admin/supplierInventory";
    }

    @RequestMapping("/supplier/editSupplier/{id}")
    public String editSupplier(@PathVariable("id") int id,  Model model){
    	Supplier supplier = supplierDao.getSupplierById(id);

        model.addAttribute("supplier", supplier);

        return "editSupplier";
    }


    @RequestMapping(value="/supplier/editSupplier", method = RequestMethod.POST)
    public String editSupplierPost(@Valid @ModelAttribute("supplier") Supplier supplier, BindingResult result, HttpServletRequest request){

        if(result.hasErrors()){
            return "editSupplier";
        }


        MultipartFile supplierImage = supplier.getSupplierImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + supplier.getSupplierid() + ".png");

        if(supplierImage != null && !supplierImage.isEmpty()){
            try {
            	supplierImage.transferTo(new File(path.toString()));
            } catch (Exception ex){
                ex.printStackTrace();
                throw new RuntimeException("Supplier image saving failed", ex);
            }
        }

        supplierDao.editSupplier(supplier);

        return "redirect:/admin/supplierInventory";
    }


    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteSupplier(@PathVariable int id, Model model, HttpServletRequest request){
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + id + ".png");

        if(Files.exists(path)){
            try {
                Files.delete(path);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }

        Supplier supplier = supplierDao.getSupplierById(id);
        supplierDao.deleteSupplier(supplier);

        return "redirect:/admin/supplierInventory";
    }

} // The End of Class;


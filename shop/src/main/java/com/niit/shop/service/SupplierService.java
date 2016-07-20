package com.niit.shop.service;

import java.util.List;

import com.niit.shop.model.Supplier;

public interface SupplierService {

    List<Supplier> getSupplierList();

    Supplier getSupplierById (int supplierid);

    void addSupplier(Supplier supplier);

    void editSupplier(Supplier supplier);

    void deleteSupplier(Supplier supplier);

}

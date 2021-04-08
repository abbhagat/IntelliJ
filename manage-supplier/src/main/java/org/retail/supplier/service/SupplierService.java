package org.retail.supplier.service;

import org.retail.supplier.model.supplier.Supplier;
import org.retail.supplier.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierDAO;

    public List<Supplier> getAllSupplier() {
        return supplierDAO.findAll();
    }

    public Supplier getSupplierByID(Long supplierID) {
        return supplierDAO.getOne(supplierID);
    }

    public Supplier getSupplierByProductID(Long productID) {
        return supplierDAO.getOne(productID);
    }

    public void saveSupplier(Supplier supplier) {
        supplierDAO.save(supplier);
    }

    public void deleteSupplierByID(Long supplierID) {
        supplierDAO.deleteById(supplierID);
    }

    public void deleteSupplier(List<Supplier> SupplierList) {
        SupplierList.forEach(supplier -> supplierDAO.deleteById(supplier.getSupplierID()));
    }

    public List<Supplier> findyExample(Supplier supplier) {
        return supplierDAO.findAll(Example.of(supplier));
    }
}

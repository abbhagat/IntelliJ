package org.retail.supplier.controller;

import org.retail.supplier.model.supplier.Supplier;
import org.retail.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @GetMapping(value = "/getAllSupplier")
    public List<Supplier> getAllSupplier() {
        return service.getAllSupplier();
    }

    @GetMapping(value = "/getSupplierByID/{supplierID}")
    public Supplier getSupplierByID(@PathVariable Long supplierID) {
        return service.getSupplierByID(supplierID);
    }

    @DeleteMapping(value = "/deleteSupplier/{supplierID}")
    public void deleteSupplierByID(@PathVariable Long supplierID) {
        service.deleteSupplierByID(supplierID);
    }

    @PostMapping(value = "/saveSupplier")
    public void saveSupplier(@RequestBody Supplier supplier) {
        service.saveSupplier(supplier);
    }

}

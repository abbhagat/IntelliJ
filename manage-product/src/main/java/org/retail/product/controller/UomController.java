package org.retail.product.controller;

import org.hibernate.SessionFactory;
import org.retail.product.model.uom.Uom;
import org.retail.product.service.UomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/uom")
public class UomController {

    @Autowired
    private UomService service;

    @Autowired
    private SessionFactory sessionFactory;

    @GetMapping(value = "/getAllUoms", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Uom> getAllUoms() {
        return service.getAllUoms();
    }

    @GetMapping(value = "/getUomByID/{uomID}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Uom getUomByID(@PathVariable Long uomID) {
        return service.getUomByID(uomID);
    }

    @PostMapping(value = "/saveUom", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void saveUom(@RequestBody Uom uom) {
        service.saveUom(uom);
    }

    @DeleteMapping(value = "/deleteUomByID/{uomID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUomByID(@PathVariable Long uomID) {
        service.deleteUomByID(uomID);
    }
}

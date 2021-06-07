package org.retail.product.service;

import org.retail.product.model.uom.Uom;
import org.retail.product.repository.UomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UomService {

    @Autowired
    private UomRepository uomDAO;

    public List<Uom> getAllUoms() {
        return uomDAO.findAll();
    }

    public Uom getUomByID(Long uomID) {
        return uomDAO.getOne(uomID);
    }

    public Uom saveUom(Uom uom) {
        return uomDAO.save(uom);
    }

    public void deleteUomByID(Long uomID) {
        uomDAO.deleteById(uomID);
    }


}

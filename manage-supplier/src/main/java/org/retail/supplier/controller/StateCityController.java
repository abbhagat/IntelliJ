package org.retail.supplier.controller;

import org.retail.supplier.model.stateCity.StateCity;
import org.retail.supplier.service.StateCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stateCity")
public class StateCityController {

    @Autowired
    private StateCityService service;

    @GetMapping(value = "/getAllStateCity")
    public List<StateCity> getAllStateCity() {
        return service.getAllStateCity();
    }

    @DeleteMapping(value = "/deleteStateCity/{stateCityID}")
    public void deleteStateCityByID(@PathVariable Long stateCityID) {
        service.deleteStateCityByID(stateCityID);
    }

    @PostMapping(value = "/saveStateCity")
    public void saveStateCity(@RequestBody StateCity stateCity) {
        service.saveStateCity(stateCity);
    }
}

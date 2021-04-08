package org.retail.supplier.service;

import org.retail.supplier.model.stateCity.StateCity;
import org.retail.supplier.repository.StateCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateCityService {

    @Autowired
    private StateCityRepository stateCityDAO;

    public List<StateCity> getAllStateCity() {
        return stateCityDAO.findAll();
    }

    public StateCity getStateCityByID(Long stateCityID) {
        return stateCityDAO.getOne(stateCityID);
    }

    public void saveStateCity(StateCity stateCity) {
        stateCityDAO.save(stateCity);
    }

    public void deleteStateCityByID(Long stateCityID) {
        stateCityDAO.deleteById(stateCityID);
    }

    public void deleteStateCity(List<StateCity> stateCityList) {
        stateCityList.forEach(stateCity -> stateCityDAO.deleteById(stateCity.getStateCityID()));
    }

    public List<StateCity> findyExample(StateCity stateCity) {
        return stateCityDAO.findAll(Example.of(stateCity));
    }
}

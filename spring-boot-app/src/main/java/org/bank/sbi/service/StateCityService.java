package org.bank.sbi.service;

import org.bank.sbi.model.statecity.StateCity;
import org.bank.sbi.model.statecity.StateCityList;
import org.bank.sbi.repository.StateCityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateCityService {

    @Autowired
    private StateCityDAO stateCityDAO;

    public List<StateCity> getAllStateCity() {
        return stateCityDAO.findAll();
    }

    public List<StateCity> searchStateCity(StateCity stateCity) {
        return stateCityDAO.findAll(Example.of(stateCity));
    }

    public void saveStateCity(StateCityList stateCityList) {
        stateCityDAO.saveAll(stateCityList.getListOfStateCity());
    }

    public StateCityList createStateCity(StateCityList stateCityList) {
        stateCityList.getListOfStateCity().add(0, new StateCity());
        return stateCityList;
    }

    public void deleteStateCityByID(Long stateCityID) {
        stateCityDAO.deleteById(stateCityID);
    }
}

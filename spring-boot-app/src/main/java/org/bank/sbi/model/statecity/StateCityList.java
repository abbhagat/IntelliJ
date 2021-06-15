package org.bank.sbi.model.statecity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StateCityList implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<StateCity> listOfStateCity;

    public StateCityList() {
        this.listOfStateCity = new ArrayList<>();
    }

    public StateCityList(List<StateCity> stateCityList) {
        this.listOfStateCity = stateCityList;
    }

    public void addStateCity(StateCity stateCity) {
        this.listOfStateCity.add(0, stateCity);
    }
}

package org.bank.sbi.controller;

import org.bank.sbi.model.statecity.StateCity;
import org.bank.sbi.model.statecity.StateCityList;
import org.bank.sbi.service.StateCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.util.StringUtils.isEmpty;

@Controller
@RequestMapping(value = "/stateCity")
public class StateCityController {

    @Autowired
    private StateCityService service;

    @ModelAttribute
    public void addingCommonAttributes(Model model) {
        model.addAttribute("PAGE_TITLE", "Manage State City");
        model.addAttribute("stateCity", new StateCity());
    }

    @GetMapping(value = "/getAllStateCity")
    public String getAllStateCity(Model model, StateCityList stateCityList) {
        stateCityList.getListOfStateCity().addAll(service.getAllStateCity());
        model.addAttribute("stateCityList", stateCityList);
        return "manage-state-city";
    }

    @GetMapping(value = "/deleteStateCity/{stateCityID}")
    public String deleteStateCityByID(@PathVariable Long stateCityID) {
        service.deleteStateCityByID(stateCityID);
        return "redirect:/stateCity/getAllStateCity";
    }

    @PostMapping(value = "/searchStateCity")
    public String searchEmployee(Model model, StateCityList stateCityList, @RequestParam(required = false) Map<String, String> map) {
        StateCity stateCity = new StateCity();
        if (!isEmpty(map.get("state"))) {
            stateCity.setState(map.get("state"));
        }
        if (!isEmpty(map.get("city"))) {
            stateCity.setCity(map.get("city"));
        }
        List<StateCity> searchResult = service.searchStateCity(stateCity);
        if (searchResult.isEmpty()) {
            stateCityList.getListOfStateCity().clear();
        } else {
            stateCityList.getListOfStateCity().addAll(searchResult);
        }
        model.addAttribute("stateCityList", stateCityList);
        return "manage-state-city";
    }

    @PostMapping(value = "/performAction")
    public String performAction(Model model, @ModelAttribute StateCityList stateCityList, @RequestParam(required = false) Map<String, String> map) {
        String action = map.get("action");
        switch (action) {
            case "Save":
                service.saveStateCity(stateCityList);
                break;
            case "Create":
                model.addAttribute("stateCityList", service.createStateCity(stateCityList));
                return "manage-state-city";
            case "Cancel":
                break;

            case "Export":
                System.out.println("Export Action");
                break;
        }
        return "redirect:/stateCity/getAllStateCity";
    }
}

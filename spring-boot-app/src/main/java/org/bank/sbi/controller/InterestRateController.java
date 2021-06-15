package org.bank.sbi.controller;

import org.bank.sbi.editor.InterestRateEditor;
import org.bank.sbi.model.roi.InterestRate;
import org.bank.sbi.service.InterestRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/interestRate")
public class InterestRateController {

    @Autowired
    private InterestRateService service;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(String.class,"interestRate", new InterestRateEditor());
    }

    @ModelAttribute
    public void addingCommonAttributes(Model model){
        model.addAttribute("manageInterestRate","Manage Interest Rate");
    }

    @GetMapping(value = "/getAllInterestRate")
    public String getAllInterestRate(Model model) {
        model.addAttribute("interestRates", service.getAllInterestRate());
        return "manage-interest-rate";
    }

    @GetMapping(value = "/createInterestRate")
    public String createInterestRate(Model model) {
        model.addAttribute("interestRates", new InterestRate());
        return "create-interest-rate";
    }

    @PostMapping(value = "/saveInterestRate")
    public String saveInterestRate(@ModelAttribute InterestRate interestRate) {
        service.saveInterestRate(interestRate);
        return "redirect:/interestRate/getAllInterestRate";
    }
}

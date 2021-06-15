package org.bank.sbi.controller;

import org.bank.sbi.editor.IFSCCodeEditor;
import org.bank.sbi.editor.MICRCodeEditor;
import org.bank.sbi.editor.PhoneNumberEditor;
import org.bank.sbi.model.bankbranch.BankBranch;
import org.bank.sbi.model.bankbranch.BankBranchList;
import org.bank.sbi.model.statecity.StateCity;
import org.bank.sbi.service.BankBranchService;
import org.bank.sbi.service.StateCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

@Controller
@RequestMapping(value = "/bankBranch")
public class BankBranchController {

    @Autowired
    private BankBranchService service;

    @Autowired
    private StateCityService stateCityService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest webRequest) {
        binder.setAutoGrowCollectionLimit(500);
        //binder.setDisallowedFields("branchName");
        int i = 0;
        while (true) {
            if (null != webRequest.getParameter("bankBranchList[" + i + "].phoneNumber")) {
                binder.registerCustomEditor(String.class, "bankBranchList[" + i + "].phoneNumber", new PhoneNumberEditor());
                binder.registerCustomEditor(String.class, "bankBranchList[" + i + "].ifscCode", new IFSCCodeEditor());
                binder.registerCustomEditor(String.class, "bankBranchList[" + i + "].micrCode", new MICRCodeEditor());
                i++;
            } else {
                break;
            }
        }
    }

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        model.addAttribute("PAGE_TITLE", "Manage Bank Branch");
        model.addAttribute("bankBranch", new BankBranch());
        List<StateCity> stateCityList = stateCityService.getAllStateCity();
        model.addAttribute("stateCityList", stateCityList);
    }

    @GetMapping(value = "/getAllBankBranch")
    public String getAllBankBranch(Model model, BankBranchList bankBranchList) {
        bankBranchList.getBankBranchList().addAll(service.getAllBankBranch());
        model.addAttribute("bankBranchList", bankBranchList);
        return "manage-bank-branch";
    }

    @PostMapping(value = "/performAction")
    public String performAction(Model model, @ModelAttribute BankBranchList bankBranchList, @RequestParam(required = false) Map<String, String> map, HttpSession session) {
        String action = map.get("action");
        switch (action) {
            case "Save":
                service.saveBankBranch(bankBranchList);
                break;
            case "Create":
                bankBranchList = service.createBankBranch(bankBranchList);
                model.addAttribute("bankBranchList", bankBranchList);
                return "manage-bank-branch";
            case "Cancel":
                break;
            case "Export":
                System.out.println("Export Action");
                break;
        }
        return "redirect:/bankBranch/getAllBankBranch";
    }

    @PostMapping(value = "/searchBankBranch")
    public String searchBankBranch(Model model, @RequestParam(required = false) Map<String, String> map, BankBranchList bankBranchList) {
        BankBranch bankBranch = new BankBranch();
        if (!isEmpty(map.get("branchName"))) {
            bankBranch.setBranchName(map.get("branchName"));
        }
        if (!isEmpty(map.get("ifscCode"))) {
            bankBranch.setIfscCode(map.get("ifscCode"));
        }
        if (!isEmpty(map.get("micrCode"))) {
            bankBranch.setMicrCode(map.get("micrCode"));
        }
        if (!isEmpty(map.get("branchManager"))) {
            bankBranch.setBranchManager(map.get("branchManager"));
        }
        if (!isEmpty(map.get("stateCityID"))) {
            bankBranch.setStateCityID(Long.valueOf(map.get("stateCityID")));
        }
        if (!isEmpty(map.get("status"))) {
            bankBranch.setStatus(map.get("status"));
        }
        bankBranchList.getBankBranchList().addAll(service.searchBankBranch(bankBranch));
        model.addAttribute("bankBranchList", bankBranchList);
        return "manage-bank-branch";
    }


}

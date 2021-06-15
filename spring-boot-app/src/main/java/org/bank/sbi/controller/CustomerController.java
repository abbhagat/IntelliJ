package org.bank.sbi.controller;

import org.bank.sbi.model.customer.Customer;
import org.bank.sbi.service.CustomerService;
import org.bank.sbi.service.StateCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static org.bank.sbi.util.StateBankConstants.*;
import static org.springframework.util.ObjectUtils.isEmpty;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @Autowired
    private StateCityService stateCityService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        model.addAttribute("PAGE_TITLE", "Manage Customer");
        model.addAttribute("PAGE_HEADER", "Manage Customer");
        model.addAttribute("CREATE_CUSTOMER", "Create Customer");
        model.addAttribute("customer", new Customer());
        model.addAttribute("stateCityList", stateCityService.getAllStateCity());

    }

    @PostMapping(value = "/searchCustomer")
    public String searchCustomer(Model model, @RequestParam Map<String, String> map) throws ParseException {
        Customer customer = new Customer();
        if (!isEmpty(map.get("firstName"))) {
            customer.setFirstName(map.get("firstName"));
        }
        if (!isEmpty(map.get("middleName"))) {
            customer.setMiddleName(map.get("middleName"));
        }
        if (!isEmpty(map.get("lastName"))) {
            customer.setLastName(map.get("lastName"));
        }
        if (!isEmpty(map.get("phoneNumber"))) {
            customer.setPhoneNumber(map.get("phoneNumber"));
        }
        if (!isEmpty(map.get("email"))) {
            customer.setEmail(map.get("email"));
        }
        if (!isEmpty(map.get("dob"))) {
            customer.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(map.get("dob")));
        }
        if (!isEmpty(map.get("pinCode"))) {
            customer.setPinCode(map.get("pinCode"));
        }
        if (!isEmpty(map.get("gender"))) {
            customer.setGender(map.get("gender"));
        }
        if (!isEmpty(map.get("stateCityID")) && !"select".equalsIgnoreCase(map.get("stateCityID"))) {
            customer.setStateCityID(Long.valueOf(map.get("stateCityID")));
        }
        model.addAttribute("cutomerList", service.searchCustomer(customer));
        return "manage-customer";
    }

    @GetMapping(value = "/getAllCustomer")
    public String getAllCustomer(Model model) {
        model.addAttribute("cutomerList", service.getAllCustomer());
        return "manage-customer";
    }

    @GetMapping(value = "/editCustomer/{customerID}")
    public String editCustomer(@PathVariable Long customerID, Model model) {
        model.addAttribute("customer", service.getCustomerByID(customerID));
        return "edit-customer";
    }

    @GetMapping(value = "/deleteCustomer/{customerID}")
    public String deleteCustomer(@PathVariable Long customerID) {
        service.deleteCustomer(customerID);
        return "redirect:/customer/getAllCustomer";
    }

    @PostMapping(value = "/performAction")
    public String performAction(Model model, @ModelAttribute Customer customer, @RequestParam Map<String, String> map, BindingResult result, @RequestParam(value = "permanentAddress", defaultValue = "New Temple Road, Bengaluru") String permanentAddress) throws Exception {
        if (!map.isEmpty()) {
            switch (map.get("action")) {
                case CREATE:
                    return "create-customer";
                case SAVE:
                    customer.setDob(new Date(new SimpleDateFormat("dd-MMM-yyyy").format(customer.getDob())));
                    service.saveCustomer(customer);
                    break;
                case DELETE:
                    service.deleteCustomer(customer);
                    break;
                case CANCEL:
                    break;
            }
        }
        return "redirect:/customer/getAllCustomer";
    }
}

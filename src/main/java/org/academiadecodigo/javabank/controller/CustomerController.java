package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller responsible for rendering {@link Customer} related views
 */
@RequestMapping("/customer")
@Controller
public class CustomerController {

    private CustomerService customerService;

    /**
     * Sets the customer service
     *
     * @param customerService the customer service to set
     */
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Renders a view with a list of customers
     *
     * @param model the model object
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/list", "/", ""})
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.list());
        return "customer/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/details/{id}")
    public String customerById(Model model, @PathVariable Integer id) {

        //GET
        Customer customer = customerService.get(id);
        //INJECT
        model.addAttribute("customer", customer);
        //VIEW
        return "customer/customer";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/delete")
    public String deleteById(@RequestParam ("id") Integer id) {

        //GET
        customerService.delete(id);
        //VIEW
        return "redirect:/customer/list";
    }
}

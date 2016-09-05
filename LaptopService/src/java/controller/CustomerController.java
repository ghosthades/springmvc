/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.CustomerDAO;
import model.pojo.Customer;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author rin
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
     

    @RequestMapping(value="/customer_list",method = RequestMethod.GET)
    public String getlist(Model mm){
       CustomerDAO model = new CustomerDAO();
       mm.addAttribute("list",model.getlist());
       return "customer_list";
    }
    @RequestMapping(value="/remove",method = RequestMethod.GET)
    public String remove(@RequestParam(value="customerId") int customerId){
        CustomerDAO model = new CustomerDAO();
        Customer e=model.getCus(customerId);
        model.remove(e);
        return "redirect:customer_list.htm";
    }
    
}

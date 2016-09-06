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
import org.springframework.web.bind.annotation.ModelAttribute;
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
     @RequestMapping(value="/edit",method = RequestMethod.GET)
    public String edit(@RequestParam(value="customerId") int customerId,Model m){
        CustomerDAO model = new CustomerDAO();
        Customer e=model.getCus(customerId);
        m.addAttribute("emp",e);
        return "customer_edit";
    }
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String update(@ModelAttribute(value="customer") Customer e){
        CustomerDAO model = new CustomerDAO();
        model.edit(e);
        return "redirect:customer_list.htm";
    }
    @RequestMapping(value="/create",method = RequestMethod.POST)
    public String create(@ModelAttribute(value="customer") Customer e){
        CustomerDAO model = new CustomerDAO();
        model.create(e);
        return "redirect:customer_list.htm";
    }
    @RequestMapping(value="/redirectCreate.htm",method = RequestMethod.GET)
    public String create(){
        return "customer_create";
    }
    @RequestMapping(value="/search",method = RequestMethod.GET)
    public String search(Model mm, String key){
       CustomerDAO model = new CustomerDAO();
       mm.addAttribute("list",model.findAll(key));
       return "customer_result";
    }
    
}

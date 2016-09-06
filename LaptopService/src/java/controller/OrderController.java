/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.CustomerDAO;
import model.dao.OrderDAO;
import model.pojo.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ri
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderDAO data = new OrderDAO();
    
    @RequestMapping(value="/order_list",method = RequestMethod.GET)
    public String getlist(Model mm){
       List<Order> list = data.getlist();
       mm.addAttribute("list",list);
       return "order_list";
    }
    @RequestMapping(value="/remove",method = RequestMethod.GET)
    public String remove(@RequestParam(value="orderId") int orderId){
        OrderDAO model = new OrderDAO();
        Order e=model.getOrd(orderId);
        model.remove(e);
        return "redirect:order_list.htm";
    }
    
    
    
    
     @RequestMapping(value="/edit",method = RequestMethod.GET)
    public String edit(@RequestParam(value="orderId") int orderId,Model m){
        OrderDAO model = new OrderDAO();
        Order e=model.getOrd(orderId);
        m.addAttribute("emp",e);
        CustomerDAO modelcus = new CustomerDAO();
        m.addAttribute("list",modelcus.getlist());
        
        return "order_edit";
    }
    
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String update(
        @RequestParam(value="orderId", required=false) int orderId, 
        @RequestParam(value="amount", required=false) String amount, 
        @RequestParam(value="detail", required=false) String detail, 
        @RequestParam(value="customerId") int customerId)
    {
        OrderDAO model = new OrderDAO();
        Order e = new Order();
        e.setOrderId(orderId);
        e.setAmount(amount);
        e.setDetail(detail);
        CustomerDAO ord = new CustomerDAO();
        e.setCustomer(ord.getCus(customerId));
        
        model.edit(e);
        return "redirect:order_list.htm";
    }
    
    
    
    
    
    
    
    @RequestMapping(value="/create",method = RequestMethod.POST)
    public String create(
        @RequestParam(value="amount", required=false) String amount, 
        @RequestParam(value="detail", required=false) String detail, 
        @RequestParam(value="customerId") int customerId)
    {
        OrderDAO model = new OrderDAO();
        Order e = new Order();
        e.setAmount(amount);
        e.setDetail(detail);
        CustomerDAO cus = new CustomerDAO();
        e.setCustomer(cus.getCus(customerId));
        
        model.create(e);
        return "redirect:order_list.htm";
    }
    @RequestMapping(value="/redirectCreate.htm",method = RequestMethod.GET)
    public String create(Model mm){
       CustomerDAO model = new CustomerDAO();
       mm.addAttribute("list",model.getlist());
       return "order_create";
    }
    
    
    
    @RequestMapping(value="/search",method = RequestMethod.GET)
    public String search(Model mm, String key){
       OrderDAO model = new OrderDAO();
       mm.addAttribute("list",model.findAll(key));
       return "order_result";
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.OrderDAO;
import model.pojo.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author rin
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
}

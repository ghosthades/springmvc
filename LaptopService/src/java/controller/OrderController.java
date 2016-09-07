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
    //lay danh sach order
    @RequestMapping(value = "/order_list", method = RequestMethod.GET)
    public String getlist(Model mm) {
        List<Order> list = data.getlist();
        mm.addAttribute("list", list);
        return "order_list";
    }
    //xoa order
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(@RequestParam(value = "orderId") int orderId) {
        OrderDAO model = new OrderDAO();
        Order e = model.getOrd(orderId);
        model.remove(e);
        return "redirect:order_list.htm";
    }
    //edit order
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "orderId") int orderId, Model m) {
        OrderDAO model = new OrderDAO();
        Order e = model.getOrd(orderId);
        m.addAttribute("emp", e);
        CustomerDAO modelcus = new CustomerDAO();
        m.addAttribute("list", modelcus.getlist());

        return "order_edit";
    }
    //update moi order sau khi nguoi dung edit
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
            @RequestParam(value = "orderId", required = false) int orderId,
            @RequestParam(value = "amount", required = false) String amount,
            @RequestParam(value = "detail", required = false) String detail,
            @RequestParam(value = "customerId") int customerId) {
        OrderDAO model = new OrderDAO();
        Order e = new Order();
        e.setOrderId(orderId);
        e.setAmount(amount);
        e.setDetail(detail);
        //tao pojo OrderDAO tu cac tham so duoc truyen tu view
        CustomerDAO ord = new CustomerDAO();
        e.setCustomer(ord.getCus(customerId));
        //ham getCus() tra ve object customer khi biet customerId
        model.edit(e);
        return "redirect:order_list.htm";
    }
    //tao moi order
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(
            @RequestParam(value = "amount", required = false) String amount,
            @RequestParam(value = "detail", required = false) String detail,
            @RequestParam(value = "customerId") int customerId) {
        OrderDAO model = new OrderDAO();
        Order e = new Order();
        //tao doi tuong pojo orderDAO
        e.setAmount(amount);
        e.setDetail(detail);
        CustomerDAO cus = new CustomerDAO();
        e.setCustomer(cus.getCus(customerId));
        ////ham getCus() tra ve object customer khi biet customerId

        model.create(e);
        return "redirect:order_list.htm";
    }
    // nhan event tu view redirect toi ham tao order moi
    @RequestMapping(value = "/redirectCreate.htm", method = RequestMethod.GET)
    public String create(Model mm) {
        CustomerDAO model = new CustomerDAO();
        mm.addAttribute("list", model.getlist());
        return "order_create";
    }
    //tim kiem order
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model mm, String key) {
        OrderDAO model = new OrderDAO();
        mm.addAttribute("list", model.findAll(key));
        return "order_result";
    }

}

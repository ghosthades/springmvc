/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Customer;
import model.pojo.Order;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author rin
 */
public class OrderDAO {
    public static List<Order> getlist(){
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        List<Order> lst = new ArrayList<Order>();
        
        try {
            s.beginTransaction();
            lst=s.createCriteria(Order.class).list();
            s.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return lst;       
    }
}

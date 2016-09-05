/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.*;
import model.pojo.*;
import model.util.HibernateUtil;
import org.hibernate.*;

/**
 *
 * @author rin
 */
public class CustomerDAO {
    public static List<Customer> getlist(){
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        List<Customer> lst = new ArrayList<Customer>();
        
        try {
            s.beginTransaction();
            lst=s.createCriteria(Customer.class).list();
            s.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return lst;       
    }
    public void create(Customer e){
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            s.save(e);
            s.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            s.getTransaction().rollback();
        }
    }
    public void remove(Customer e){
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            s.delete(e);
            s.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            s.getTransaction().rollback();
        }
    }
    public void edit(Customer e){
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            s.update(e);
            s.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            s.getTransaction().rollback();
        }
    }
    public Customer getCus(int customerId){
        Session s =HibernateUtil.getSessionFactory().getCurrentSession();
        Customer e = new Customer();
        try{
            s.beginTransaction();
            e=(Customer)s.get(Customer.class,customerId);
            s.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            s.getTransaction().rollback();
        }
        return e;
    }
}

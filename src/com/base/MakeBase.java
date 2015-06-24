package com.base;

import com.parser.Parser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by JK on 2015-06-24.
 */
public class MakeBase {
    public MakeBase() {
        setCurrency();
        managerFactory = Persistence.createEntityManagerFactory("myDatabase");
        manager = managerFactory.createEntityManager();
        setEurBase();
        manager.close();
        managerFactory.close();
    }
    public Date getDateSql() {
        java.util.Date todaysDate = new java.util.Date();
        dateSql = new Date(todaysDate.getTime());
        return dateSql;
    }

    public void setCurrency(){
        Parser parser = new Parser();
        currency = parser.getCurrency();
    }
    public void setEurBase(){
        EURbase base = new EURbase();
        base.setValueOfEur(currency.get(0));
        base.setDateSql(getDateSql());
        addBase(base);
    }
    public void addBase(Object obj){
        manager.getTransaction().begin();
        manager.persist(obj);
        manager.getTransaction().commit();
    }

    private java.sql.Date dateSql;
    private EntityManagerFactory managerFactory;
    private EntityManager manager;
    private ArrayList<Double> currency;
}

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
        setBases();
        manager.close();
        managerFactory.close();
    }
    public void setBases(){
        setEurBase();
        setUsdBase();
        setChfBase();
        setGbpBase();
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
        EURbase euRbase = new EURbase();
        euRbase.setValueOfEur(currency.get(0));
        euRbase.setDateSql(getDateSql());
        addBase(euRbase);
    }
    public void setUsdBase(){
        USDbase usDbase = new USDbase();
        usDbase.setValueOfUSD(currency.get(1));
        usDbase.setDateSql(getDateSql());
        addBase(usDbase);
    }
    public void setChfBase(){
        CHFbase chFbase = new CHFbase();
        chFbase.setValueOfChf(currency.get(2));
        chFbase.setDateSql(getDateSql());
        addBase(chFbase);
    }
    public void setGbpBase(){
        GBPbase gbPbase = new GBPbase();
        gbPbase.setValueOfGbp(currency.get(3));
        gbPbase.setDateSql(getDateSql());
        addBase(gbPbase);
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

package com.base;

import com.parser.Parser;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by JK on 2015-06-24.
 */
public class MakeBase {
    public MakeBase() {
        setCurrency();
        managerFactory = Persistence.createEntityManagerFactory("myDatabase");
        manager = managerFactory.createEntityManager();
        setBases();
        getTodaysDate();
        manager.close();
        managerFactory.close();
    }
    public void setBases(){
        try {
            if (checkDates() == true){
                setEurBase();
                setUsdBase();
                setChfBase();
                setGbpBase();
            }
            else System.out.println();
        }catch (Exception e){
            setEurBase();
            setUsdBase();
            setChfBase();
            setGbpBase();
        }

    }
    public java.sql.Date getTodaysDate() {
        Query query = manager.createQuery("select e from EURbase e where Id = (select max(id) from EURbase)");
        EURbase euRbase = (EURbase) query.getSingleResult();
        System.out.println(euRbase.getDateSql());
        return euRbase.getDateSql();
    }
    public boolean checkDates(){
        try{
            todaysDate = new java.util.Date();
            Calendar calendarBase = Calendar.getInstance();
            calendarBase.setTime(getTodaysDate());
            Calendar calendarNow = Calendar.getInstance();
            calendarNow.setTime(todaysDate);
            if (calendarBase.get(Calendar.YEAR) == calendarNow.get(Calendar.YEAR) &&
                    calendarBase.get(Calendar.DAY_OF_YEAR) == calendarNow.get(Calendar.DAY_OF_YEAR)) return false;
            else return true;
        }catch (Exception e){
            return true;
        }
    }
    public Date getDateSql() {
        todaysDate = new java.util.Date();
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
    private java.util.Date todaysDate;
    private EntityManagerFactory managerFactory;
    private EntityManager manager;
    private ArrayList<Double> currency;
}

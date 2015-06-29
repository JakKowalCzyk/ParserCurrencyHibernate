package com.base;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JK on 2015-06-26.
 */
public class Selectfrom {
    public Selectfrom(EntityManager manager) {
        this.manager = manager;
    }
    public List<EURbase> selectEUR(){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<EURbase> criteriaQuery = builder.createQuery(EURbase.class);
        Root<EURbase> euRbaseRoot = criteriaQuery.from(EURbase.class);
        TypedQuery<EURbase> query = manager.createQuery(criteriaQuery);
        List<EURbase> euRbases = query.getResultList();
        return euRbases;
    }
    public List<USDbase> selectUSD(){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<USDbase> criteriaQuery = builder.createQuery(USDbase.class);
        Root<USDbase> usDbaseRoot = criteriaQuery.from(USDbase.class);
        TypedQuery<USDbase> query = manager.createQuery(criteriaQuery);
        List<USDbase> usDbases = query.getResultList();
        return usDbases;
    }
    public List<CHFbase> selectCHF(){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<CHFbase> criteriaQuery = builder.createQuery(CHFbase.class);
        Root<CHFbase> usDbaseRoot = criteriaQuery.from(CHFbase.class);
        TypedQuery<CHFbase> query = manager.createQuery(criteriaQuery);
        List<CHFbase> chFbases = query.getResultList();
        return chFbases;
     }
    public List<GBPbase> selectGBP(){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<GBPbase> criteriaQuery = builder.createQuery(GBPbase.class);
        Root<GBPbase> usDbaseRoot = criteriaQuery.from(GBPbase.class);
        TypedQuery<GBPbase> query = manager.createQuery(criteriaQuery);
        List<GBPbase> gbPbases = query.getResultList();
        return gbPbases;
    }
    public String selectMaxEur() {
        Query query = manager.createQuery("select e from EURbase e where valueOfEur = (select max(valueOfEur) from EURbase)");
        EURbase euRbase = (EURbase) query.getSingleResult();
        return "Max EUR = " + euRbase.getDateSql() + "  -  " + euRbase.getValueOfEur();
    }
    public String selectMinEur(){
        Query query = manager.createQuery("select e from EURbase e where valueOfEur = (select min(valueOfEur) from EURbase)");
        EURbase euRbase = (EURbase) query.getSingleResult();
        return "Min EUR = " + euRbase.getDateSql() + "  -  " + euRbase.getValueOfEur();
    }
    public String selectMaxUSD() {
        Query query = manager.createQuery("select e from USDbase e where valueOfUSD = (select max(valueOfUSD) from USDbase)");
        USDbase usDbase = (USDbase) query.getSingleResult();
        return "Max USD = " + usDbase.getDateSql() + "  -  " + usDbase.getValueOfUSD();
    }
    public String selectMinUSD() {
        Query query = manager.createQuery("select e from USDbase e where valueOfUSD = (select min(valueOfUSD) from USDbase)");
        USDbase usDbase = (USDbase) query.getSingleResult();
        return "Min USD = " + usDbase.getDateSql() + "  -  " + usDbase.getValueOfUSD();
    }
    public String selectMaxChf() {
        Query query = manager.createQuery("select e from CHFbase e where valueOfChf = (select max(valueOfChf) from CHFbase)");
        CHFbase chFbase = (CHFbase) query.getSingleResult();
        return "Max CHF = " + chFbase.getDateSql() + "  -  " + chFbase.getValueOfChf();
    }
    public String selectMinChf() {
        Query query = manager.createQuery("select e from CHFbase e where valueOfChf = (select min(valueOfChf) from CHFbase)");
        CHFbase chFbase = (CHFbase) query.getSingleResult();
        return "Min CHF = " + chFbase.getDateSql() + "  -  " + chFbase.getValueOfChf();
    }
    public String selectMaxGbp() {
        Query query = manager.createQuery("select e from GBPbase e where valueOfGbp = (select max(valueOfGbp) from GBPbase)");
        GBPbase gbPbase = (GBPbase) query.getSingleResult();
        return "Max GBP = " + gbPbase.getDateSql() + "  -  " + gbPbase.getValueOfGbp();
    }
    public String selectMinGbp() {
        Query query = manager.createQuery("select e from GBPbase e where valueOfGbp = (select min(valueOfGbp) from GBPbase)");
        GBPbase gbPbase = (GBPbase) query.getSingleResult();
        return "Min GBP = " + gbPbase.getDateSql() + "  -  " + gbPbase.getValueOfGbp();
    }

    private EntityManager manager;
    private EURbase euRbase;
    private USDbase usDbase;
    private CHFbase chFbase;
    private GBPbase gbPbase;
}

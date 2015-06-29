package com.base;

import javax.persistence.EntityManager;
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

    private EntityManager manager;
    private EURbase euRbase;
    private USDbase usDbase;
    private CHFbase chFbase;
    private GBPbase gbPbase;
}

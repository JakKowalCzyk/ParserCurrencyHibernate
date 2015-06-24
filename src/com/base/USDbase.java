package com.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by DK on 2015-06-24.
 */
@Entity
public class USDbase {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getValueOfEur() {
        return valueOfUSD;
    }

    public void setValueOfEur(Double valueOfEur) {
        this.valueOfUSD = valueOfEur;
    }

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "Value")
    private Double valueOfUSD;
    @Column(name = "Date")
    private java.sql.Date dateSql;

}

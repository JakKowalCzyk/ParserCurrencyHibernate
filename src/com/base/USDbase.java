package com.base;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by DK on 2015-06-24.
 */
@Entity
@Table(name = "USD")
public class USDbase {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getValueOfUSD() {
        return valueOfUSD;
    }

    public void setValueOfUSD(Double valueOfUSD) {
        this.valueOfUSD = valueOfUSD;
    }

    public Date getDateSql() {
        return dateSql;
    }

    public void setDateSql(Date dateSql) {
        this.dateSql = dateSql;
    }

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "Value")
    private Double valueOfUSD;
    @Column(name = "Date")
    private java.sql.Date dateSql;

}

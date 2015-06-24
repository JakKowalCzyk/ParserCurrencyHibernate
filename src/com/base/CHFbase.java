package com.base;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by DK on 2015-06-24.
 */
@Entity
@Table(name = "CHF")
public class CHFbase {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getValueOfChf() {
        return valueOfChf;
    }

    public void setValueOfChf(Double valueOfChf) {
        this.valueOfChf = valueOfChf;
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
    private Double valueOfChf;
    @Column(name = "Date")
    private java.sql.Date dateSql;
}

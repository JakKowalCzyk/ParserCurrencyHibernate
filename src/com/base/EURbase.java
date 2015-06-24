package com.base;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by JK on 2015-06-24.
 */
@Entity
@Table(name = "EUR")
public class EURbase {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getValueOfEur() {
        return valueOfEur;
    }

    public void setValueOfEur(Double valueOfEur) {
        this.valueOfEur = valueOfEur;
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
    private Double valueOfEur;
    @Column(name = "Date")
    private java.sql.Date dateSql;
}

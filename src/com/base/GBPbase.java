package com.base;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by DK on 2015-06-24.
 */
@Entity
@Table(name = "GBP")
public class GBPbase {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getValueOfGbp() {
        return valueOfGbp;
    }

    public void setValueOfGbp(Double valueOfGbp) {
        this.valueOfGbp = valueOfGbp;
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
    private Double valueOfGbp;
    @Column(name = "Date")
    private java.sql.Date dateSql;
}

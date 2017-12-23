package com.easywork.mycrm.persistence;

import javax.persistence.*;

public class Department {
    @Id
    private Integer id;

    private String dname;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return dname
     */
    public String getDname() {
        return dname;
    }

    /**
     * @param dname
     */
    public void setDname(String dname) {
        this.dname = dname;
    }
}
package com.easywork.mycrm.persistence;

import javax.persistence.*;

public class Resetpass {
    @Id
    private Integer id;

    private String username;

    @Column(name = "phoneNo")
    private String phoneno;

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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return phoneNo
     */
    public String getPhoneno() {
        return phoneno;
    }

    /**
     * @param phoneno
     */
    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
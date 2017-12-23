package com.easywork.mycrm.persistence;

import javax.persistence.*;

public class Employee {
    @Id
    private Integer id;

    private String username;

    private String pass;

    private String nickname;

    private String realname;

    @Column(name = "jobInfoId")
    private Integer jobinfoid;

    @Column(name = "departmentId")
    private Integer departmentid;

    @Column(name = "phoneNo")
    private String phoneno;

    @Column(name = "officeTel")
    private String officetel;

    @Column(name = "workStatu")
    private String workstatu;

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
     * @return pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return realname
     */
    public String getRealname() {
        return realname;
    }

    /**
     * @param realname
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * @return jobInfoId
     */
    public Integer getJobinfoid() {
        return jobinfoid;
    }

    /**
     * @param jobinfoid
     */
    public void setJobinfoid(Integer jobinfoid) {
        this.jobinfoid = jobinfoid;
    }

    /**
     * @return departmentId
     */
    public Integer getDepartmentid() {
        return departmentid;
    }

    /**
     * @param departmentid
     */
    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
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

    /**
     * @return officeTel
     */
    public String getOfficetel() {
        return officetel;
    }

    /**
     * @param officetel
     */
    public void setOfficetel(String officetel) {
        this.officetel = officetel;
    }

    /**
     * @return workStatu
     */
    public String getWorkstatu() {
        return workstatu;
    }

    /**
     * @param workstatu
     */
    public void setWorkstatu(String workstatu) {
        this.workstatu = workstatu;
    }
}
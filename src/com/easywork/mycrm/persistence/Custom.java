package com.easywork.mycrm.persistence;

import java.util.Date;
import javax.persistence.*;

public class Custom {
    @Id
    private Integer id;

    private String name;

    private String education;

    @Column(name = "phoneNo")
    private String phoneno;

    private String qq;

    private String email;

    @Column(name = "customStatu")
    private String customstatu;

    @Column(name = "createDate")
    private Date createdate;

    @Column(name = "inviteName")
    private String invitename;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return education
     */
    public String getEducation() {
        return education;
    }

    /**
     * @param education
     */
    public void setEducation(String education) {
        this.education = education;
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
     * @return qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return customStatu
     */
    public String getCustomstatu() {
        return customstatu;
    }

    /**
     * @param customstatu
     */
    public void setCustomstatu(String customstatu) {
        this.customstatu = customstatu;
    }

    /**
     * @return createDate
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * @return inviteName
     */
    public String getInvitename() {
        return invitename;
    }

    /**
     * @param invitename
     */
    public void setInvitename(String invitename) {
        this.invitename = invitename;
    }
}
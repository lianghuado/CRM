package com.easywork.mycrm.persistence;

import java.util.Date;
import javax.persistence.*;

public class Consultrecord {
    @Id
    private Integer id;

    @Column(name = "customId")
    private Integer customid;

    @Column(name = "consultStatu")
    private String consultstatu;

    @Column(name = "consultManId")
    private Integer consultmanid;

    @Column(name = "consultDate")
    private Date consultdate;

    private String result;

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
     * @return customId
     */
    public Integer getCustomid() {
        return customid;
    }

    /**
     * @param customid
     */
    public void setCustomid(Integer customid) {
        this.customid = customid;
    }

    /**
     * @return consultStatu
     */
    public String getConsultstatu() {
        return consultstatu;
    }

    /**
     * @param consultstatu
     */
    public void setConsultstatu(String consultstatu) {
        this.consultstatu = consultstatu;
    }

    /**
     * @return consultManId
     */
    public Integer getConsultmanid() {
        return consultmanid;
    }

    /**
     * @param consultmanid
     */
    public void setConsultmanid(Integer consultmanid) {
        this.consultmanid = consultmanid;
    }

    /**
     * @return consultDate
     */
    public Date getConsultdate() {
        return consultdate;
    }

    /**
     * @param consultdate
     */
    public void setConsultdate(Date consultdate) {
        this.consultdate = consultdate;
    }

    /**
     * @return result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }
}
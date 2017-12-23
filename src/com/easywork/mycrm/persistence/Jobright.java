package com.easywork.mycrm.persistence;

import javax.persistence.*;

public class Jobright {
    @Id
    private Integer id;

    @Column(name = "jobInfoId")
    private Integer jobinfoid;

    @Column(name = "rightId")
    private Integer rightid;

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
     * @return rightId
     */
    public Integer getRightid() {
        return rightid;
    }

    /**
     * @param rightid
     */
    public void setRightid(Integer rightid) {
        this.rightid = rightid;
    }
}
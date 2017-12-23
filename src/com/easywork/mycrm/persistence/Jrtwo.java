package com.easywork.mycrm.persistence;

import javax.persistence.*;

public class Jrtwo {
    @Id
    private Integer id;

    private Integer jobinfoid;

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
     * @return jobinfoid
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
     * @return rightid
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
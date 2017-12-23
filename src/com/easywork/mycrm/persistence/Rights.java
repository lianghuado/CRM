package com.easywork.mycrm.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class Rights implements Serializable{    

	/**
	 * 
	 */
	private static final long serialVersionUID = -304416764902812244L;

	@Id
    private Integer rid;

    @Column(name = "rightName")
    private String rightname;

    @Column(name = "rightType")
    private String righttype;

    private String url;

    private Integer pid;

    /**
     * @return rid
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * @param rid
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * @return rightName
     */
    public String getRightname() {
        return rightname;
    }

    /**
     * @param rightname
     */
    public void setRightname(String rightname) {
        this.rightname = rightname;
    }

    /**
     * @return rightType
     */
    public String getRighttype() {
        return righttype;
    }

    /**
     * @param righttype
     */
    public void setRighttype(String righttype) {
        this.righttype = righttype;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
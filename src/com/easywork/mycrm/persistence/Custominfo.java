package com.easywork.mycrm.persistence;

import java.util.Date;
import javax.persistence.*;

public class Custominfo {
    @Id
    private Integer id;

    @Column(name = "customId")
    private Integer customid;

    @Column(name = "followManId")
    private Integer followmanid;

    private String statu;

    @Column(name = "startDate")
    private Date startdate;

    @Column(name = "planDate")
    private Date plandate;

    @Column(name = "lastFollowDate")
    private Date lastfollowdate;

    private String mark;

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
     * @return followManId
     */
    public Integer getFollowmanid() {
        return followmanid;
    }

    /**
     * @param followmanid
     */
    public void setFollowmanid(Integer followmanid) {
        this.followmanid = followmanid;
    }

    /**
     * @return statu
     */
    public String getStatu() {
        return statu;
    }

    /**
     * @param statu
     */
    public void setStatu(String statu) {
        this.statu = statu;
    }

    /**
     * @return startDate
     */
    public Date getStartdate() {
        return startdate;
    }

    /**
     * @param startdate
     */
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    /**
     * @return planDate
     */
    public Date getPlandate() {
        return plandate;
    }

    /**
     * @param plandate
     */
    public void setPlandate(Date plandate) {
        this.plandate = plandate;
    }

    /**
     * @return lastFollowDate
     */
    public Date getLastfollowdate() {
        return lastfollowdate;
    }

    /**
     * @param lastfollowdate
     */
    public void setLastfollowdate(Date lastfollowdate) {
        this.lastfollowdate = lastfollowdate;
    }

    /**
     * @return mark
     */
    public String getMark() {
        return mark;
    }

    /**
     * @param mark
     */
    public void setMark(String mark) {
        this.mark = mark;
    }
}
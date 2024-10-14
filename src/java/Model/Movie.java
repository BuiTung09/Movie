/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;
/**
 *
 * @author acmon
 */
public class Movie {
     private int mid;
    private String mtitle;
    private Date releasedDate;
    private boolean adultOnly;
    private int cid; // Category ID

    public Movie(int mid, String mtitle, Date releasedDate, boolean adultOnly, int cid) {
        this.mid = mid;
        this.mtitle = mtitle;
        this.releasedDate = releasedDate;
        this.adultOnly = adultOnly;
        this.cid = cid;
    }

    public Movie() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getMid() {
        return mid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public boolean isAdultOnly() {
        return adultOnly;
    }

    public int getCid() {
        return cid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public void setAdultOnly(boolean adultOnly) {
        this.adultOnly = adultOnly;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author blank
 */
@Entity
@Table(name = "TransDetail", catalog = "pointofsales", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransDetail.findAll", query = "SELECT t FROM TransDetail t"),
    @NamedQuery(name = "TransDetail.findByNo", query = "SELECT t FROM TransDetail t WHERE t.no = :no"),
    @NamedQuery(name = "TransDetail.findByidntid", query = "SELECT t FROM TransDetail t WHERE t.id = :id AND t.transid = :transid"),
    @NamedQuery(name = "TransDetail.findByidndatentime", query = "SELECT t FROM TransDetail t WHERE t.id = :id AND t.date = :date"),
    @NamedQuery(name = "TransDetail.findByTransid", query = "SELECT t FROM TransDetail t WHERE t.transid = :transid"),
    @NamedQuery(name = "TransDetail.findweekly", query = "SELECT t FROM TransDetail t WHERE t.id = :id AND t.date between :first AND :second"),
    @NamedQuery(name = "TransDetail.findByDate", query = "SELECT t FROM TransDetail t WHERE t.date = :date"),
    @NamedQuery(name = "TransDetail.findById", query = "SELECT t FROM TransDetail t WHERE t.id = :id"),
    @NamedQuery(name = "TransDetail.findByTime", query = "SELECT t FROM TransDetail t WHERE t.time = :time"),
    @NamedQuery(name = "TransDetail.findByTotal", query = "SELECT t FROM TransDetail t WHERE t.total = :total")})
public class TransDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no")
    private Integer no;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "transid")
    private String transid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "time")
    private String time;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "total")
    private String total;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Login id;

    public TransDetail() {
    }

    public TransDetail(Integer no) {
        this.no = no;
    }

    public TransDetail(Integer no, String transid, String date, String time, String total) {
        this.no = no;
        this.transid = transid;
        this.date = date;
        this.time = time;
        this.total = total;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Login getId() {
        return id;
    }

    public void setId(Login id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransDetail)) {
            return false;
        }
        TransDetail other = (TransDetail) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TransDetail[ no=" + no + " ]";
    }
    
}

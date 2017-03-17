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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author INSPIRON 15
 */
@Entity
@Table(name = "customerdetail", catalog = "pointofsales", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customerdetail.findAll", query = "SELECT c FROM Customerdetail c")
    , @NamedQuery(name = "Customerdetail.findByNo", query = "SELECT c FROM Customerdetail c WHERE c.no = :no")
    , @NamedQuery(name = "Customerdetail.findByDetailno", query = "SELECT c FROM Customerdetail c WHERE c.detailno = :detailno")
    , @NamedQuery(name = "Customerdetail.findByCustno", query = "SELECT c FROM Customerdetail c WHERE c.custno = :custno")
    , @NamedQuery(name = "Customerdetail.findByCustnonId", query = "SELECT c FROM Customerdetail c WHERE c.custno = :custno AND c.id = :id")
    , @NamedQuery(name = "Customerdetail.findByDate", query = "SELECT c FROM Customerdetail c WHERE c.date = :date")
    , @NamedQuery(name = "Customerdetail.findByTime", query = "SELECT c FROM Customerdetail c WHERE c.time = :time")
    , @NamedQuery(name = "Customerdetail.findByTransid", query = "SELECT c FROM Customerdetail c WHERE c.transid = :transid")
    , @NamedQuery(name = "Customerdetail.findByidncustno", query = "SELECT c FROM Customerdetail c WHERE c.id = :id AND c.custno = :custno")
    , @NamedQuery(name = "Customerdetail.findByidncustnontid", query = "SELECT c FROM Customerdetail c WHERE c.id = :id AND c.custno = :custno AND c.transid = :tid")
    , @NamedQuery(name = "Customerdetail.findByRemain", query = "SELECT c FROM Customerdetail c WHERE c.remain = :remain")
    , @NamedQuery(name = "Customerdetail.findById", query = "SELECT c FROM Customerdetail c WHERE c.id = :id")})
public class Customerdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no")
    private Integer no;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "detailno")
    private String detailno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "custno")
    private String custno;
    @Size(max = 45)
    @Column(name = "date")
    private String date;
    @Size(max = 45)
    @Column(name = "time")
    private String time;
    @Size(max = 45)
    @Column(name = "transid")
    private String transid;
    @Size(max = 45)
    @Column(name = "remain")
    private String remain;
    @Size(max = 45)
    @Column(name = "id")
    private String id;

    public Customerdetail() {
    }

    public Customerdetail(Integer no) {
        this.no = no;
    }

    public Customerdetail(Integer no, String detailno, String custno) {
        this.no = no;
        this.detailno = detailno;
        this.custno = custno;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getDetailno() {
        return detailno;
    }

    public void setDetailno(String detailno) {
        this.detailno = detailno;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
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

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        if (!(object instanceof Customerdetail)) {
            return false;
        }
        Customerdetail other = (Customerdetail) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Customerdetail[ no=" + no + " ]";
    }

}

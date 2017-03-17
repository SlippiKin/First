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
@Table(name = "floorplan", catalog = "pointofsales", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Floorplan.findAll", query = "SELECT f FROM Floorplan f")
    , @NamedQuery(name = "Floorplan.findByNo", query = "SELECT f FROM Floorplan f WHERE f.no = :no")
    , @NamedQuery(name = "Floorplan.findById", query = "SELECT f FROM Floorplan f WHERE f.id = :id")
    , @NamedQuery(name = "Floorplan.findByShelfname", query = "SELECT f FROM Floorplan f WHERE f.shelfname = :shelfname")
    , @NamedQuery(name = "Floorplan.findByLevel", query = "SELECT f FROM Floorplan f WHERE f.level = :level")
    , @NamedQuery(name = "Floorplan.findByLocation", query = "SELECT f FROM Floorplan f WHERE f.location = :location")
    , @NamedQuery(name = "Floorplan.findByShape", query = "SELECT f FROM Floorplan f WHERE f.shape = :shape")})
public class Floorplan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no")
    private Integer no;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "shelfname")
    private String shelfname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "level")
    private String level;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "shape")
    private String shape;

    public Floorplan() {
    }

    public Floorplan(Integer no) {
        this.no = no;
    }

    public Floorplan(Integer no, String id, String shelfname, String level, String location, String shape) {
        this.no = no;
        this.id = id;
        this.shelfname = shelfname;
        this.level = level;
        this.location = location;
        this.shape = shape;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShelfname() {
        return shelfname;
    }

    public void setShelfname(String shelfname) {
        this.shelfname = shelfname;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
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
        if (!(object instanceof Floorplan)) {
            return false;
        }
        Floorplan other = (Floorplan) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Floorplan[ no=" + no + " ]";
    }
    
}

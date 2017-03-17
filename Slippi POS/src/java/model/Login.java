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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author A645653
 */
@Entity
@Table(name = "login", catalog = "pointofsales", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")
    , @NamedQuery(name = "Login.findById", query = "SELECT l FROM Login l WHERE l.id = :id")
    , @NamedQuery(name = "Login.findByPassword", query = "SELECT l FROM Login l WHERE l.password = :password")
    , @NamedQuery(name = "Login.findByName", query = "SELECT l FROM Login l WHERE l.name = :name")
    , @NamedQuery(name = "Login.findByDob", query = "SELECT l FROM Login l WHERE l.dob = :dob")
    , @NamedQuery(name = "Login.findByHp", query = "SELECT l FROM Login l WHERE l.hp = :hp")
    , @NamedQuery(name = "Login.findByBusname", query = "SELECT l FROM Login l WHERE l.busname = :busname")
    , @NamedQuery(name = "Login.findByEmail", query = "SELECT l FROM Login l WHERE l.email = :email")
    , @NamedQuery(name = "Login.findBySuccessful", query = "SELECT l FROM Login l WHERE l.successful = :successful")
    , @NamedQuery(name = "Login.findByUnsuccessful", query = "SELECT l FROM Login l WHERE l.unsuccessful = :unsuccessful")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dob")
    private String dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "hp")
    private String hp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "busname")
    private String busname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "successful")
    private String successful;
    @Size(max = 45)
    @Column(name = "unsuccessful")
    private String unsuccessful;

    public Login() {
    }

    public Login(String id) {
        this.id = id;
    }

    public Login(String id, String password, String name, String dob, String hp, String busname, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.hp = hp;
        this.busname = busname;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getBusname() {
        return busname;
    }

    public void setBusname(String busname) {
        this.busname = busname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSuccessful() {
        return successful;
    }

    public void setSuccessful(String successful) {
        this.successful = successful;
    }

    public String getUnsuccessful() {
        return unsuccessful;
    }

    public void setUnsuccessful(String unsuccessful) {
        this.unsuccessful = unsuccessful;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Login[ id=" + id + " ]";
    }
    
}

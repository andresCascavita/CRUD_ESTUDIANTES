/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiantesJEE.entity;

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
 * @author ANDRES CASCAVITA
 */
@Entity
@Table(name = "UNTITLED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Untitled.findAll", query = "SELECT u FROM Untitled u"),
    @NamedQuery(name = "Untitled.findByStudentid", query = "SELECT u FROM Untitled u WHERE u.studentid = :studentid"),
    @NamedQuery(name = "Untitled.findByFirstname", query = "SELECT u FROM Untitled u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "Untitled.findByLastname", query = "SELECT u FROM Untitled u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Untitled.findByYearlevel", query = "SELECT u FROM Untitled u WHERE u.yearlevel = :yearlevel")})
public class Untitled implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "STUDENTID")
    private String studentid;
    @Size(max = 20)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 20)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 20)
    @Column(name = "YEARLEVEL")
    private String yearlevel;

    public Untitled() {
    }

    public Untitled(String studentid, String firstname, String lastname, String yearlevel) {
        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearlevel = yearlevel;
    }

    public Untitled(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getYearlevel() {
        return yearlevel;
    }

    public void setYearlevel(String yearlevel) {
        this.yearlevel = yearlevel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentid != null ? studentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Untitled)) {
            return false;
        }
        Untitled other = (Untitled) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "estudiantesJEE.entity.Untitled[ studentid=" + studentid + " ]";
    }
    
}

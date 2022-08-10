package com.chaudq.milktea.model2;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GomComputer
 */
@Entity
@Table(name = "feedback")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f")
        , @NamedQuery(name = "Feedback.findById", query = "SELECT f FROM Feedback f WHERE f.id = :id")
        , @NamedQuery(name = "Feedback.findByWater", query = "SELECT f FROM Feedback f WHERE f.water = :water")
        , @NamedQuery(name = "Feedback.findByElectric", query = "SELECT f FROM Feedback f WHERE f.electric = :electric")
        , @NamedQuery(name = "Feedback.findByInternet", query = "SELECT f FROM Feedback f WHERE f.internet = :internet")
        , @NamedQuery(name = "Feedback.findBySecurity", query = "SELECT f FROM Feedback f WHERE f.security = :security")
        , @NamedQuery(name = "Feedback.findByMonth", query = "SELECT f FROM Feedback f WHERE f.month = :month")
        , @NamedQuery(name = "Feedback.findByEnvironment", query = "SELECT f FROM Feedback f WHERE f.environment = :environment")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Basic(optional = false)
    @Column(name = "Water")
    private int water;
    @Basic(optional = false)
    @Column(name = "Electric")
    private int electric;
    @Basic(optional = false)
    @Column(name = "Internet")
    private int internet;
    @Basic(optional = false)
    @Column(name = "Security")
    private int security;
    @Column(name = "Month")
    private String month;
    @Basic(optional = false)
    @Column(name = "Environment")
    private int environment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "feedbackId")
    private List<Bill> billList;

    public Feedback() {
    }

    public Feedback(String id) {
        this.id = id;
    }

    public Feedback(String id, int water, int electric, int internet, int security, int environment) {
        this.id = id;
        this.water = water;
        this.electric = electric;
        this.internet = internet;
        this.security = security;
        this.environment = environment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getElectric() {
        return electric;
    }

    public void setElectric(int electric) {
        this.electric = electric;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    public int getSecurity() {
        return security;
    }

    public void setSecurity(int security) {
        this.security = security;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getEnvironment() {
        return environment;
    }

    public void setEnvironment(int environment) {
        this.environment = environment;
    }

    @XmlTransient
    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
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
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hiu.Feedback[ id=" + id + " ]";
    }

}

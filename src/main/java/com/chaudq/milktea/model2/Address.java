package com.chaudq.milktea.model2;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "address")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
        , @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id")
        , @NamedQuery(name = "Address.findByLatitue", query = "SELECT a FROM Address a WHERE a.latitue = :latitue")
        , @NamedQuery(name = "Address.findByLongtitue", query = "SELECT a FROM Address a WHERE a.longtitue = :longtitue")
        , @NamedQuery(name = "Address.findByDetail", query = "SELECT a FROM Address a WHERE a.detail = :detail")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "Latitue")
    private String latitue;
    @Column(name = "Longtitue")
    private String longtitue;
    @Column(name = "Detail")
    private String detail;
    @JoinColumn(name = "StreetId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Street streetId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private List<Hostel> hostelList;

    public Address() {
    }

    public Address(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLatitue() {
        return latitue;
    }

    public void setLatitue(String latitue) {
        this.latitue = latitue;
    }

    public String getLongtitue() {
        return longtitue;
    }

    public void setLongtitue(String longtitue) {
        this.longtitue = longtitue;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Street getStreetId() {
        return streetId;
    }

    public void setStreetId(Street streetId) {
        this.streetId = streetId;
    }

    @XmlTransient
    public List<Hostel> getHostelList() {
        return hostelList;
    }

    public void setHostelList(List<Hostel> hostelList) {
        this.hostelList = hostelList;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hiu.Address[ id=" + id + " ]";
    }

}

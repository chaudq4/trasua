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
@Table(name = "fee")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Fee.findAll", query = "SELECT f FROM Fee f")
        , @NamedQuery(name = "Fee.findById", query = "SELECT f FROM Fee f WHERE f.id = :id")
        , @NamedQuery(name = "Fee.findByMonth", query = "SELECT f FROM Fee f WHERE f.month = :month")
        , @NamedQuery(name = "Fee.findByNumberOfElectric", query = "SELECT f FROM Fee f WHERE f.numberOfElectric = :numberOfElectric")
        , @NamedQuery(name = "Fee.findByNumberOfWater", query = "SELECT f FROM Fee f WHERE f.numberOfWater = :numberOfWater")
        , @NamedQuery(name = "Fee.findByInternet", query = "SELECT f FROM Fee f WHERE f.internet = :internet")
        , @NamedQuery(name = "Fee.findByPark", query = "SELECT f FROM Fee f WHERE f.park = :park")
        , @NamedQuery(name = "Fee.findByOther", query = "SELECT f FROM Fee f WHERE f.other = :other")})
public class Fee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "Month")
    private String month;
    @Basic(optional = false)
    @Column(name = "NumberOfElectric")
    private int numberOfElectric;
    @Basic(optional = false)
    @Column(name = "NumberOfWater")
    private int numberOfWater;


    @Basic(optional = false)
    @Column(name = "Park")
    private int park;
    @Basic(optional = false)
    @Column(name = "Other")
    private int other;
    @JoinColumn(name = "RentId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Rent rentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "feeId")
    private List<Bill> billList;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Fee(String id, String month, int numberOfElectric, int numberOfWater, int park, int other,  String status) {
        this.id = id;
        this.month = month;
        this.numberOfElectric = numberOfElectric;
        this.numberOfWater = numberOfWater;

        this.park = park;
        this.other = other;

        this.status = status;
    }

    public Fee() {
    }

    public Fee(String id) {
        this.id = id;
    }

    public Fee(String id, int numberOfElectric, int numberOfWater, int internet, int park, int other) {
        this.id = id;
        this.numberOfElectric = numberOfElectric;
        this.numberOfWater = numberOfWater;

        this.park = park;
        this.other = other;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getNumberOfElectric() {
        return numberOfElectric;
    }

    public void setNumberOfElectric(int numberOfElectric) {
        this.numberOfElectric = numberOfElectric;
    }

    public int getNumberOfWater() {
        return numberOfWater;
    }

    public void setNumberOfWater(int numberOfWater) {
        this.numberOfWater = numberOfWater;
    }


    public int getPark() {
        return park;
    }

    public void setPark(int park) {
        this.park = park;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public Rent getRentId() {
        return rentId;
    }

    public void setRentId(Rent rentId) {
        this.rentId = rentId;
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
        if (!(object instanceof Fee)) {
            return false;
        }
        Fee other = (Fee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hiu.Fee[ id=" + id + " ]";
    }

}

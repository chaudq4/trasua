package com.chaudq.milktea.model2;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GomComputer
 */
@Entity
@Table(name = "people")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "People.findAll", query = "SELECT p FROM People p")
        , @NamedQuery(name = "People.findById", query = "SELECT p FROM People p WHERE p.id = :id")
        , @NamedQuery(name = "People.findByName", query = "SELECT p FROM People p WHERE p.name = :name")
        , @NamedQuery(name = "People.findByDob", query = "SELECT p FROM People p WHERE p.dob = :dob")
        , @NamedQuery(name = "People.findByPhone", query = "SELECT p FROM People p WHERE p.phone = :phone")
        , @NamedQuery(name = "People.findByAddress", query = "SELECT p FROM People p WHERE p.address = :address")})
public class People implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Dob")
    private String dob;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Address")
    private String address;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "people")
    private Lodger lodger;
    @JoinColumn(name = "AccountId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Account accountId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "people")
    private Landlady landlady;
    private String sex;
    public People() {
    }


    public People(String id, String name, String dob, String phone, String address, Account accountId) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.lodger = lodger;
        this.accountId = accountId;
        this.landlady = landlady;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public People(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Lodger getLodger() {
        return lodger;
    }

    public void setLodger(Lodger lodger) {
        this.lodger = lodger;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Landlady getLandlady() {
        return landlady;
    }

    public void setLandlady(Landlady landlady) {
        this.landlady = landlady;
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
        if (!(object instanceof People)) {
            return false;
        }
        People other = (People) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hiu.People[ id=" + id + " ]";
    }

}

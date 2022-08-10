package com.chaudq.milktea.model2;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GomComputer
 */
@Entity
@Table(name = "landlady")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Landlady.findAll", query = "SELECT l FROM Landlady l")
        , @NamedQuery(name = "Landlady.findByPeopleId", query = "SELECT l FROM Landlady l WHERE l.peopleId = :peopleId")})
public class Landlady implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PeopleId")
    private String peopleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "landladyPeopleId")
    private List<Hostel> hostelList;
    @JoinColumn(name = "PeopleId", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private People people;

    public Landlady() {
    }

    public Landlady(String peopleId) {
        this.peopleId = peopleId;
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    @XmlTransient
    public List<Hostel> getHostelList() {
        return hostelList;
    }

    public void setHostelList(List<Hostel> hostelList) {
        this.hostelList = hostelList;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peopleId != null ? peopleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Landlady)) {
            return false;
        }
        Landlady other = (Landlady) object;
        if ((this.peopleId == null && other.peopleId != null) || (this.peopleId != null && !this.peopleId.equals(other.peopleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hiu.Landlady[ peopleId=" + peopleId + " ]";
    }

}

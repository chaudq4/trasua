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
@Table(name = "lodger")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Lodger.findAll", query = "SELECT l FROM Lodger l")
        , @NamedQuery(name = "Lodger.findBySchool", query = "SELECT l FROM Lodger l WHERE l.school = :school")
        , @NamedQuery(name = "Lodger.findByJob", query = "SELECT l FROM Lodger l WHERE l.job = :job")
        , @NamedQuery(name = "Lodger.findByPeopleId", query = "SELECT l FROM Lodger l WHERE l.peopleId = :peopleId")})
public class Lodger implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "School")
    private String school;
    @Column(name = "Job")
    private String job;
    @Id
    @Basic(optional = false)
    @Column(name = "PeopleId")
    private String peopleId;
    @JoinColumn(name = "PeopleId", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private People people;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lodgerPeopleId")
    private List<Rent> rentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lodgerPeopleId")
    private List<Order1> order1List;

    public Lodger() {
    }

    public Lodger(String peopleId) {
        this.peopleId = peopleId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @XmlTransient
    public List<Rent> getRentList() {
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    @XmlTransient
    public List<Order1> getOrder1List() {
        return order1List;
    }

    public void setOrder1List(List<Order1> order1List) {
        this.order1List = order1List;
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
        if (!(object instanceof Lodger)) {
            return false;
        }
        Lodger other = (Lodger) object;
        if ((this.peopleId == null && other.peopleId != null) || (this.peopleId != null && !this.peopleId.equals(other.peopleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hiu.Lodger[ peopleId=" + peopleId + " ]";
    }

}

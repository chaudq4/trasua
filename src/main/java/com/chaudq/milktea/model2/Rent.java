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
@Table(name = "rent")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Rent.findAll", query = "SELECT r FROM Rent r")
        , @NamedQuery(name = "Rent.findById", query = "SELECT r FROM Rent r WHERE r.id = :id")
        , @NamedQuery(name = "Rent.findByStartTime", query = "SELECT r FROM Rent r WHERE r.startTime = :startTime")
        , @NamedQuery(name = "Rent.findByEndTime", query = "SELECT r FROM Rent r WHERE r.endTime = :endTime")})
public class Rent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "StartTime")
    private String startTime;
    @Column(name = "EndTime")
    private String endTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rentId")
    private List<Fee> feeList;
    @JoinColumn(name = "RoomId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Room roomId;
    @JoinColumn(name = "LodgerPeopleId", referencedColumnName = "PeopleId")
    @ManyToOne(optional = false)
    private Lodger lodgerPeopleId;

    public Rent() {
    }

    public Rent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @XmlTransient
    public List<Fee> getFeeList() {
        return feeList;
    }

    public void setFeeList(List<Fee> feeList) {
        this.feeList = feeList;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public Lodger getLodgerPeopleId() {
        return lodgerPeopleId;
    }

    public void setLodgerPeopleId(Lodger lodgerPeopleId) {
        this.lodgerPeopleId = lodgerPeopleId;
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
        if (!(object instanceof Rent)) {
            return false;
        }
        Rent other = (Rent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hiu.Rent[ id=" + id + " ]";
    }

}

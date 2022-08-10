package com.chaudq.milktea.model2;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GomComputer
 */
@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o")
        , @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id")
        , @NamedQuery(name = "Order1.findByTimeOrder", query = "SELECT o FROM Order1 o WHERE o.timeOrder = :timeOrder")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "TimeOrder")
    private String timeOrder;
    @JoinColumn(name = "LodgerPeopleId", referencedColumnName = "PeopleId")
    @ManyToOne(optional = false)
    private Lodger lodgerPeopleId;
    @JoinColumn(name = "RoomId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Room roomId;

    public Order1() {
    }

    public Order1(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(String timeOrder) {
        this.timeOrder = timeOrder;
    }

    public Lodger getLodgerPeopleId() {
        return lodgerPeopleId;
    }

    public void setLodgerPeopleId(Lodger lodgerPeopleId) {
        this.lodgerPeopleId = lodgerPeopleId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
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
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hiu.Order1[ id=" + id + " ]";
    }

}

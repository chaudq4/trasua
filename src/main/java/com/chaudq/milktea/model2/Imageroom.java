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
@Table(name = "imageroom")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Imageroom.findAll", query = "SELECT i FROM Imageroom i")
        , @NamedQuery(name = "Imageroom.findById", query = "SELECT i FROM Imageroom i WHERE i.id = :id")
        , @NamedQuery(name = "Imageroom.findByLink", query = "SELECT i FROM Imageroom i WHERE i.link = :link")})
public class Imageroom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "Link")
    private String link;
    @JoinColumn(name = "RoomId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Room roomId;

    public Imageroom() {
    }

    public Imageroom(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
        if (!(object instanceof Imageroom)) {
            return false;
        }
        Imageroom other = (Imageroom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hiu.Imageroom[ id=" + id + " ]";
    }

}

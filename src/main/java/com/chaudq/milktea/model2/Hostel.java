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
@Table(name = "hostel")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Hostel.findAll", query = "SELECT h FROM Hostel h")
        , @NamedQuery(name = "Hostel.findById", query = "SELECT h FROM Hostel h WHERE h.id = :id")
        , @NamedQuery(name = "Hostel.findByNumber", query = "SELECT h FROM Hostel h WHERE h.number = :number")
        , @NamedQuery(name = "Hostel.findByCamera", query = "SELECT h FROM Hostel h WHERE h.camera = :camera")
        , @NamedQuery(name = "Hostel.findByPark", query = "SELECT h FROM Hostel h WHERE h.park = :park")
        , @NamedQuery(name = "Hostel.findByPrice", query = "SELECT h FROM Hostel h WHERE h.price = :price")
        , @NamedQuery(name = "Hostel.findByDescrition", query = "SELECT h FROM Hostel h WHERE h.descrition = :descrition")
        , @NamedQuery(name = "Hostel.findByName", query = "SELECT h FROM Hostel h WHERE h.name = :name")})
public class Hostel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Basic(optional = false)
    @Column(name = "Number")
    private int number;
    @Column(name = "Camera")
    private String camera;
    @Column(name = "Park")
    private String park;
    @Column(name = "Price")
    private String price;
    @Column(name = "Descrition")
    private String descrition;
    @Column(name = "Name")
    private String name;
    @JoinColumn(name = "AddressId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Address addressId;
    @JoinColumn(name = "LandladyPeopleId", referencedColumnName = "PeopleId")
    @ManyToOne(optional = false)
    private Landlady landladyPeopleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hostelId")
    private List<Room> roomList;

    public Hostel() {
    }

    public Hostel(String id) {
        this.id = id;
    }

    public Hostel(String id, int number) {
        this.id = id;
        this.number = number;
    }

    public Hostel(String id, int number, String camera, String park, String price, String descrition, String name) {
        this.id = id;
        this.number = number;
        this.camera = camera;
        this.park = park;
        this.price = price;
        this.descrition = descrition;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Landlady getLandladyPeopleId() {
        return landladyPeopleId;
    }

    public void setLandladyPeopleId(Landlady landladyPeopleId) {
        this.landladyPeopleId = landladyPeopleId;
    }

    @XmlTransient
    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
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
        if (!(object instanceof Hostel)) {
            return false;
        }
        Hostel other = (Hostel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hiu.Hostel[ id=" + id + " ]";
    }

}

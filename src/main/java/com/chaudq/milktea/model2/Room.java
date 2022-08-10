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
@Table(name = "room")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
        , @NamedQuery(name = "Room.findById", query = "SELECT r FROM Room r WHERE r.id = :id")
        , @NamedQuery(name = "Room.findBySquare", query = "SELECT r FROM Room r WHERE r.square = :square")
        , @NamedQuery(name = "Room.findByKitchen", query = "SELECT r FROM Room r WHERE r.kitchen = :kitchen")
        , @NamedQuery(name = "Room.findByWc", query = "SELECT r FROM Room r WHERE r.wc = :wc")
        , @NamedQuery(name = "Room.findByBed", query = "SELECT r FROM Room r WHERE r.bed = :bed")
        , @NamedQuery(name = "Room.findByAirConditional", query = "SELECT r FROM Room r WHERE r.airConditional = :airConditional")
        , @NamedQuery(name = "Room.findByWaterHeater", query = "SELECT r FROM Room r WHERE r.waterHeater = :waterHeater")
        , @NamedQuery(name = "Room.findByPrice", query = "SELECT r FROM Room r WHERE r.price = :price")
        , @NamedQuery(name = "Room.findByElectric", query = "SELECT r FROM Room r WHERE r.electric = :electric")
        , @NamedQuery(name = "Room.findByWater", query = "SELECT r FROM Room r WHERE r.water = :water")
        , @NamedQuery(name = "Room.findByInternet", query = "SELECT r FROM Room r WHERE r.internet = :internet")
        , @NamedQuery(name = "Room.findByStatus", query = "SELECT r FROM Room r WHERE r.status = :status")
        , @NamedQuery(name = "Room.findByName", query = "SELECT r FROM Room r WHERE r.name = :name")
        , @NamedQuery(name = "Room.findByDescription", query = "SELECT r FROM Room r WHERE r.description = :description")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "Square")
    private String square;
    @Column(name = "Kitchen")
    private String kitchen;
    @Column(name = "WC")
    private String wc;
    @Column(name = "Bed")
    private String bed;
    @Column(name = "AirConditional")
    private String airConditional;
    @Column(name = "WaterHeater")
    private String waterHeater;
    @Column(name = "Price")
    private String price;
    @Column(name = "Electric")
    private String electric;
    @Column(name = "Water")
    private String water;
    @Column(name = "Internet")
    private String internet;
    @Column(name = "Status")
    private String status;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private List<Imageroom> imageroomList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private List<Rent> rentList;
    @JoinColumn(name = "HostelId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Hostel hostelId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private List<Order1> order1List;

    public Room() {
    }

    public Room(String id, String square, String kitchen, String wc, String bed, String airConditional, String waterHeater, String price, String electric, String water, String internet, String status, String name, String description) {
        this.id = id;
        this.square = square;
        this.kitchen = kitchen;
        this.wc = wc;
        this.bed = bed;
        this.airConditional = airConditional;
        this.waterHeater = waterHeater;
        this.price = price;
        this.electric = electric;
        this.water = water;
        this.internet = internet;
        this.status = status;
        this.name = name;
        this.description = description;
    }

    public Room(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    public String getWc() {
        return wc;
    }

    public void setWc(String wc) {
        this.wc = wc;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getAirConditional() {
        return airConditional;
    }

    public void setAirConditional(String airConditional) {
        this.airConditional = airConditional;
    }

    public String getWaterHeater() {
        return waterHeater;
    }

    public void setWaterHeater(String waterHeater) {
        this.waterHeater = waterHeater;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getElectric() {
        return electric;
    }

    public void setElectric(String electric) {
        this.electric = electric;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Imageroom> getImageroomList() {
        return imageroomList;
    }

    public void setImageroomList(List<Imageroom> imageroomList) {
        this.imageroomList = imageroomList;
    }

    @XmlTransient
    public List<Rent> getRentList() {
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    public Hostel getHostelId() {
        return hostelId;
    }

    public void setHostelId(Hostel hostelId) {
        this.hostelId = hostelId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hiu.Room[ id=" + id + " ]";
    }

}

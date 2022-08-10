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
@Table(name = "bill")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b")
        , @NamedQuery(name = "Bill.findById", query = "SELECT b FROM Bill b WHERE b.id = :id")
        , @NamedQuery(name = "Bill.findByTimePay", query = "SELECT b FROM Bill b WHERE b.timePay = :timePay")
        , @NamedQuery(name = "Bill.findByTypePay", query = "SELECT b FROM Bill b WHERE b.typePay = :typePay")})
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "TimePay")
    private String timePay;
    @Column(name = "TypePay")
    private String typePay;
    @JoinColumn(name = "FeedbackId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Feedback feedbackId;
    @JoinColumn(name = "FeeId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Fee feeId;

    public Bill() {
    }

    public Bill(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimePay() {
        return timePay;
    }

    public void setTimePay(String timePay) {
        this.timePay = timePay;
    }

    public String getTypePay() {
        return typePay;
    }

    public void setTypePay(String typePay) {
        this.typePay = typePay;
    }

    public Feedback getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Feedback feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Fee getFeeId() {
        return feeId;
    }

    public void setFeeId(Fee feeId) {
        this.feeId = feeId;
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
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hiu.Bill[ id=" + id + " ]";
    }

}

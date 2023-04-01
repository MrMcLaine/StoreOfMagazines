package ua.magazines.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private String id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "magazine_id", referencedColumnName = "id")
    private Magazine magazine;
    @Column(name = "date_of_payment")
    private Date dateOfPayment;
    @Column(name = "sum_payment")
    private Double sumPayment;

    public Payment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public Double getSumPayment() {
        return sumPayment;
    }

    public void setSumPayment(Double sumPayment) {
        this.sumPayment = sumPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;

        if (getId() != null ? !getId().equals(payment.getId()) : payment.getId() != null) return false;
        if (getUser() != null ? !getUser().equals(payment.getUser()) : payment.getUser() != null) return false;
        if (getMagazine() != null ? !getMagazine().equals(payment.getMagazine()) : payment.getMagazine() != null)
            return false;
        if (getDateOfPayment() != null ? !getDateOfPayment().equals(payment.getDateOfPayment()) : payment.getDateOfPayment() != null)
            return false;
        return getSumPayment() != null ? getSumPayment().equals(payment.getSumPayment()) : payment.getSumPayment() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getMagazine() != null ? getMagazine().hashCode() : 0);
        result = 31 * result + (getDateOfPayment() != null ? getDateOfPayment().hashCode() : 0);
        result = 31 * result + (getSumPayment() != null ? getSumPayment().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Payment{" +
               "id=" + id +
               ", user=" + user +
               ", magazine=" + magazine +
               ", dateOfPayment=" + dateOfPayment +
               ", sumPayment=" + sumPayment +
               '}';
    }
}

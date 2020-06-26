package lk.ijse.hotelbackend.entity;

import javax.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String date;

    @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;

    private double price;
    private String status;

    public Payment(int id, String date, Reservation reservation, double price, String status) {
        this.id = id;
        this.date = date;
        this.reservation = reservation;
        this.price = price;
        this.status = status;
    }

    public Payment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", reservation=" + reservation +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}

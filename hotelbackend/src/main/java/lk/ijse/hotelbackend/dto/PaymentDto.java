package lk.ijse.hotelbackend.dto;

public class PaymentDto {
    private int id;
    private String date;
    private ReservationDto reservationDto;
    private double fee;
    private String status;

    public PaymentDto(int id, String date, ReservationDto reservationDto, double fee, String status) {
        this.id = id;
        this.date = date;
        this.reservationDto = reservationDto;
        this.fee = fee;
        this.status = status;
    }

    public PaymentDto() {
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

    public ReservationDto getReservationDto() {
        return reservationDto;
    }

    public void setReservationDto(ReservationDto reservationDto) {
        this.reservationDto = reservationDto;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentDto{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", reservationDto=" + reservationDto +
                ", fee=" + fee +
                ", status='" + status + '\'' +
                '}';
    }
}

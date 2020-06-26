package lk.ijse.hotelbackend.dto;

public class ReservationDto {
    private int id;
    private RoomDto roomDto;
    private String checkInDate;
    private String checkOutDate;
    private String user;
    private String status;

    public ReservationDto() {
    }

    public ReservationDto(int id, RoomDto roomDto, String checkInDate, String checkOutDate, String user,String status) {
        this.id = id;
        this.roomDto = roomDto;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.user = user;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomDto getRoomDto() {
        return roomDto;
    }

    public void setRoomDto(RoomDto roomDto) {
        this.roomDto = roomDto;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReservationDto{" +
                "id=" + id +
                ", roomDto=" + roomDto +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                ", user='" + user + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

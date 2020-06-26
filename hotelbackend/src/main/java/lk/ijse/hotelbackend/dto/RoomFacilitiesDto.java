package lk.ijse.hotelbackend.dto;

import java.util.List;

public class RoomFacilitiesDto {
    private int id;
    private RoomDto roomDto;
    private List<FacilitiesDto> dtolist;

    public RoomFacilitiesDto() {
    }

    public RoomFacilitiesDto(int id,RoomDto roomDto, List<FacilitiesDto> dtolist) {
        this.id = id;
        this.roomDto = roomDto;
        this.dtolist = dtolist;
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

    public List<FacilitiesDto> getDtolist() {
        return dtolist;
    }

    public void setDtolist(List<FacilitiesDto> dtolist) {
        this.dtolist = dtolist;
    }

    @Override
    public String toString() {
        return "RoomFacilitiesDto{" +
                "id=" + id +
                ", roomDto=" + roomDto +
                ", dtolist=" + dtolist +
                '}';
    }
}

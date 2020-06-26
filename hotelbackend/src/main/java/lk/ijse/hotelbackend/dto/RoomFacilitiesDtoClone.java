package lk.ijse.hotelbackend.dto;

import java.util.List;

public class RoomFacilitiesDtoClone {
    private int id;
    private RoomDtoClone roomDto;
    private List<FacilitiesDto> dtolist;

    public RoomFacilitiesDtoClone() {
    }

    public RoomFacilitiesDtoClone(int id, RoomDtoClone roomDto, List<FacilitiesDto> dtolist) {
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

    public RoomDtoClone getRoomDto() {
        return roomDto;
    }

    public void setRoomDto(RoomDtoClone roomDto) {
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
        return "RoomFacilitiesDtoClone{" +
                "id=" + id +
                ", roomDto=" + roomDto +
                ", dtolist=" + dtolist +
                '}';
    }
}

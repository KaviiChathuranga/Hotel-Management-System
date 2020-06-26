package lk.ijse.hotelbackend.service;

import lk.ijse.hotelbackend.dto.RoomFacilitiesDto;

import java.util.List;

public interface RoomFacilitiesService {

    RoomFacilitiesDto findRoomFacilitiesService(String id);
    boolean saveRoomFacilitiesService(RoomFacilitiesDto roomDto);
    boolean updateRoomFacilitiesService(RoomFacilitiesDto roomDto);
    List<RoomFacilitiesDto> getAllRoomFacilitiesService();
    long getTotalRooms();
}

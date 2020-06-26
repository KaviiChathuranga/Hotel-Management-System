package lk.ijse.hotelbackend.service;

import lk.ijse.hotelbackend.dto.RoomDto;

import java.util.List;

public interface RoomService {
     RoomDto findRoomService(String id);
     List<RoomDto> findRoomByTypeService(String id);
     boolean saveRoomService(RoomDto roomDto);
     boolean updateRoomService(RoomDto roomDto);
     List<RoomDto> getAllRoomService();
     long getTotalRooms();
}

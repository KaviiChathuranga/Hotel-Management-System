package lk.ijse.hotelbackend.service.impl;

import lk.ijse.hotelbackend.dto.RoomDto;
import lk.ijse.hotelbackend.entity.Room;
import lk.ijse.hotelbackend.repository.RoomRepository;
import lk.ijse.hotelbackend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public RoomDto findRoomService(String id) {
        Room one = roomRepository.findById(id).get();
        if(one!=null){
            return new RoomDto(one.getId(),one.getName(),one.getType(),one.getReserveType(),one.getDescription(),one.getPrice(),one.getFacilities());
        }
        return null;

    }

    @Override
    public List<RoomDto> findRoomByTypeService(String type) {
        List<Room> all = roomRepository.findType(type);
        List<RoomDto>dtoList=new ArrayList<>();
        if (all!=null){
            System.out.println("not null");
            all.forEach(room -> {
                System.out.println(room);
                dtoList.add(new RoomDto(room.getId(),room.getName(),room.getType(),room.getReserveType(),room.getDescription(),room.getPrice(),room.getFacilities()));
            });
            return dtoList;
        }
        System.out.println(" null");
  return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveRoomService(RoomDto roomDto) {
        System.out.println("saveRoomService : ");
        roomRepository.save(new Room(roomDto.getId(),roomDto.getName(),roomDto.getType(),roomDto.getReserveType(),roomDto.getDescription(),roomDto.getPrice(),roomDto.getFacilities()));
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateRoomService(RoomDto roomDto) {

        roomRepository.save(new Room(roomDto.getId(),roomDto.getName(),roomDto.getType(),roomDto.getReserveType(),roomDto.getDescription(),roomDto.getPrice(),roomDto.getFacilities()));
        return true;

    }

    @Override
    public List<RoomDto> getAllRoomService() {
        List<Room> all = roomRepository.findAll();
        List<RoomDto>dtoList=new ArrayList<>();
        all.forEach(room -> {
            dtoList.add(new RoomDto(room.getId(),room.getName(),room.getType(),room.getReserveType(),room.getDescription(),room.getPrice(),room.getFacilities()));
        });
        return dtoList;
    }

    @Override
    public long getTotalRooms() {
        return roomRepository.getTotalItems();
    }
}

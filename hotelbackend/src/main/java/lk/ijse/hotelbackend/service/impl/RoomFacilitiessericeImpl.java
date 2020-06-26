package lk.ijse.hotelbackend.service.impl;

import lk.ijse.hotelbackend.dto.RoomFacilitiesDto;
import lk.ijse.hotelbackend.entity.Facilities;
import lk.ijse.hotelbackend.entity.Room;
import lk.ijse.hotelbackend.entity.RoomFacilities;
import lk.ijse.hotelbackend.repository.RoomFacilitiesRepository;
import lk.ijse.hotelbackend.service.RoomFacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class RoomFacilitiessericeImpl implements RoomFacilitiesService {
    @Autowired
    private RoomFacilitiesRepository roomFacilitiesRepository;

    @Override
    public RoomFacilitiesDto findRoomFacilitiesService(String id) {
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean saveRoomFacilitiesService(RoomFacilitiesDto roomDto) {


        System.out.println("n1  "+roomDto.getDtolist());
        List<Facilities>facilitiesList=new ArrayList<>();
        roomDto.getDtolist().forEach(facilitiesDto -> {
            System.out.println("n2");
            System.out.println(facilitiesDto.getId());
//            x++;
//            System.out.println("x "+x);
            facilitiesList.add(new Facilities(facilitiesDto.getId(),facilitiesDto.getName(),facilitiesDto.getPrice()));
        });
        System.out.println(roomDto);
         roomFacilitiesRepository.save(new RoomFacilities(roomDto.getId(),
                 new Room(roomDto.getRoomDto().getId(),
                         roomDto.getRoomDto().getName(),
                         roomDto.getRoomDto().getType(),
                         roomDto.getRoomDto().getReserveType(),
                         roomDto.getRoomDto().getDescription(),
                         roomDto.getRoomDto().getPrice(),
                         roomDto.getRoomDto().getFacilities()
//                         roomDto.getRoomDto().getFile()
                 ),
                 facilitiesList));
        System.out.println("n4");
         return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateRoomFacilitiesService(RoomFacilitiesDto roomDto) {
        return false;
    }

    @Override
    public List<RoomFacilitiesDto> getAllRoomFacilitiesService() {
        return null;
    }

    @Override
    public long getTotalRooms() {
        return roomFacilitiesRepository.getTotalfacilitiesList();
    }
}

package lk.ijse.hotelbackend.controller;

import lk.ijse.hotelbackend.dto.RoomFacilitiesDto;
import lk.ijse.hotelbackend.dto.RoomFacilitiesDtoClone;
import lk.ijse.hotelbackend.service.RoomFacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/room_facilities")
public class RoomFacilityController {
    @Autowired
    private RoomFacilitiesService roomFacilitiesService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoomFacilitiesDto> getAllRoomFacilities(){
        return roomFacilitiesService.getAllRoomFacilitiesService();
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RoomFacilitiesDto findRoomFacilities(@PathVariable("id") String id){
        return roomFacilitiesService.findRoomFacilitiesService(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveRoomFacilities(@RequestBody RoomFacilitiesDto roomDto){
        roomDto.getDtolist().forEach(facilitiesDto -> {
            System.out.println("faci ID :  "+facilitiesDto.getId());
        });
        System.out.println("roomID :  "+roomDto.getRoomDto().getId());
        System.out.println("ID :  "+roomDto.getId());
        return roomFacilitiesService.saveRoomFacilitiesService(roomDto);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalRooms(){
        return roomFacilitiesService.getTotalRooms();
    }
}

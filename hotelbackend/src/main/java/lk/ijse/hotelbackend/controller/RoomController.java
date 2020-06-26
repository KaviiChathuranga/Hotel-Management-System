package lk.ijse.hotelbackend.controller;

import lk.ijse.hotelbackend.dto.RoomDto;
import lk.ijse.hotelbackend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoomDto> getAllRooms(){
       return roomService.getAllRoomService();
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RoomDto findRoom(@PathVariable("id") String id){
       // System.out.println("Id is  :  "+id);
        System.out.println("findRoom : ");
        return roomService.findRoomService(id);
    }
    @GetMapping(value = "/type/{type}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoomDto> findRoomByType(@PathVariable("type") String type){
        System.out.println("findRoomByType : ");
        return roomService.findRoomByTypeService(type);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveRoom(@RequestBody RoomDto roomDto){
        System.out.println("saveRoom : ");
        return roomService.saveRoomService(roomDto);
    }
    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalRooms(){
        return roomService.getTotalRooms();
    }
}

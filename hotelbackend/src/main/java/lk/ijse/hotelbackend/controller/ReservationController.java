package lk.ijse.hotelbackend.controller;

import lk.ijse.hotelbackend.dto.ReservationDto;
import lk.ijse.hotelbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationDto> getAllRoomsReservation(){
        return reservationService.getAllRoomReservation();
    }

    @GetMapping(value = "/{d1}/{d2}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationDto> findRoomReservation(@PathVariable("d1") String d1,@PathVariable("d2") String d2){
        System.out.println("dates : "+d1+" :  "+d2);
        return reservationService.findRoomReservation(d1,d2);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveRoomReservation(@RequestBody ReservationDto reservationDto){
        System.out.println("saveRoomReservation : ");
        return reservationService.saveRoomReservation(reservationDto);
    }
    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalRoomsReservation(){
        return reservationService.getTotalReservation();
    }
}

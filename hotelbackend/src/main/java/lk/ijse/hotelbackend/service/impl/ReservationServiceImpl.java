package lk.ijse.hotelbackend.service.impl;

import lk.ijse.hotelbackend.dto.ReservationDto;
import lk.ijse.hotelbackend.dto.RoomDto;
import lk.ijse.hotelbackend.entity.Reservation;
import lk.ijse.hotelbackend.entity.Room;
import lk.ijse.hotelbackend.repository.ReservationRepository;
import lk.ijse.hotelbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<ReservationDto> findRoomReservation(String d1,String d2) {

       List<Reservation> reservationsList = reservationRepository.findRoomIsReserve(d1,d2);
        List<ReservationDto> dtoList = new ArrayList<>();
        reservationsList.forEach(reservation -> {
            dtoList.add(new ReservationDto(
                    reservation.getId(),
                    new RoomDto(
                            reservation.getRoom().getId(),
                            reservation.getRoom().getName(),
                            reservation.getRoom().getType(),
                            reservation.getRoom().getReserveType(),
                            reservation.getRoom().getDescription(),
                            reservation.getRoom().getPrice(),
                            reservation.getRoom().getFacilities()
//                            reservation.getRoom().getFile()
                    ),
                    reservation.getCheckInDate(),
                    reservation.getCheckOutDate(),
                    reservation.getUser(),
                    reservation.getStatus()
            ));
        });
        return dtoList;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean saveRoomReservation(ReservationDto roomReservationDto) {
        System.out.println("saveRoomReservation : ");
        try {

            reservationRepository.save(new Reservation(
                    roomReservationDto.getId(),
                    new Room(
                            roomReservationDto.getRoomDto().getId(),
                            roomReservationDto.getRoomDto().getName(),
                            roomReservationDto.getRoomDto().getType(),
                            roomReservationDto.getRoomDto().getReserveType(),
                            roomReservationDto.getRoomDto().getDescription(),
                            roomReservationDto.getRoomDto().getPrice(),
                            roomReservationDto.getRoomDto().getFacilities()
//                            roomReservationDto.getRoomDto().getFile()
                    ),
                    roomReservationDto.getCheckInDate(),
                    roomReservationDto.getCheckOutDate(),
                    roomReservationDto.getUser(),
                    roomReservationDto.getStatus()
            ));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateRoomReservation(ReservationDto roomReservationDto) {
        try {

            reservationRepository.save(new Reservation(
                    roomReservationDto.getId(),
                    new Room(
                            roomReservationDto.getRoomDto().getId(),
                            roomReservationDto.getRoomDto().getName(),
                            roomReservationDto.getRoomDto().getType(),
                            roomReservationDto.getRoomDto().getReserveType(),
                            roomReservationDto.getRoomDto().getDescription(),
                            roomReservationDto.getRoomDto().getPrice(),
                            roomReservationDto.getRoomDto().getFacilities()
//                            roomReservationDto.getRoomDto().getFile()
                    ),
                    roomReservationDto.getCheckInDate(),
                    roomReservationDto.getCheckOutDate(),
                    roomReservationDto.getUser(),
                    roomReservationDto.getStatus()
            ));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public List<ReservationDto> getAllRoomReservation() {
        List<Reservation> reservationsList = reservationRepository.findAll();
        List<ReservationDto> dtoList = new ArrayList<>();
        reservationsList.forEach(reservation -> {
            dtoList.add(new ReservationDto(
                    reservation.getId(),
                    new RoomDto(
                            reservation.getRoom().getId(),
                            reservation.getRoom().getName(),
                            reservation.getRoom().getType(),
                            reservation.getRoom().getReserveType(),
                            reservation.getRoom().getDescription(),
                            reservation.getRoom().getPrice(),
                            reservation.getRoom().getFacilities()
//                            reservation.getRoom().getFile()
                    ),
                    reservation.getCheckInDate(),
                    reservation.getCheckOutDate(),
                    reservation.getUser(),
                    reservation.getStatus()
            ));
        });
        return dtoList;
    }

    @Override
    public long getTotalReservation() {
        return reservationRepository.getTotalItems();
    }
}

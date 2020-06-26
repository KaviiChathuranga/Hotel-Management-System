package lk.ijse.hotelbackend.service;

import lk.ijse.hotelbackend.dto.ReservationDto;

import java.util.List;

public interface ReservationService {
    List<ReservationDto> findRoomReservation(String d1,String d2);
    boolean saveRoomReservation(ReservationDto roomReservationDto);
    boolean updateRoomReservation(ReservationDto roomReservationDto);
    List<ReservationDto> getAllRoomReservation();
    long getTotalReservation();
}

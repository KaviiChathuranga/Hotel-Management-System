package lk.ijse.hotelbackend.service.impl;

import lk.ijse.hotelbackend.dto.PaymentDto;
import lk.ijse.hotelbackend.dto.ReservationDto;
import lk.ijse.hotelbackend.dto.RoomDto;
import lk.ijse.hotelbackend.entity.Payment;
import lk.ijse.hotelbackend.entity.Reservation;
import lk.ijse.hotelbackend.entity.Room;
import lk.ijse.hotelbackend.repository.PaymentRepository;
import lk.ijse.hotelbackend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public PaymentDto findPaymentService(String id) {
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean savePaymentService(PaymentDto paymentDto) {
        System.out.println("savePaymentService : ");
        System.out.println("paymentDtoID : "+paymentDto);
        System.out.println("getReservationDtoID : "+paymentDto.getReservationDto());
        System.out.println("getRoomDtoID : "+paymentDto.getReservationDto().getRoomDto());

        try {
            paymentRepository.save(new Payment(
                    paymentDto.getId(),
                    paymentDto.getDate(),
                    new Reservation(paymentDto.getReservationDto().getId(),
                            new Room(
                                    paymentDto.getReservationDto().getRoomDto().getId(),
                                    paymentDto.getReservationDto().getRoomDto().getName(),
                                    paymentDto.getReservationDto().getRoomDto().getType(),
                                    paymentDto.getReservationDto().getRoomDto().getReserveType(),
                                    paymentDto.getReservationDto().getRoomDto().getDescription(),
                                    paymentDto.getReservationDto().getRoomDto().getPrice(),
                                    paymentDto.getReservationDto().getRoomDto().getFacilities()
//                                    paymentDto.getReservationDto().getRoomDto().getFile()
                            ),
                            paymentDto.getReservationDto().getCheckInDate(),
                            paymentDto.getReservationDto().getCheckOutDate(),
                            paymentDto.getReservationDto().getUser(),
                            paymentDto.getReservationDto().getStatus()),
                    paymentDto.getFee(),
                    paymentDto.getStatus()
            ));
            return true;
        } catch (Exception e){
            return false;
        }
    }


    @Override
    public List<PaymentDto> getAllPaymentService() {
        List<Payment> paymentList = paymentRepository.findAll();
        List<PaymentDto> dtoList = new ArrayList<>();
        paymentList.forEach(payment -> {
            dtoList.add(new PaymentDto(
                    payment.getId(),
                    payment.getDate(),
                    new ReservationDto(
                            payment.getReservation().getId(),
                            new RoomDto(
                                    payment.getReservation().getRoom().getId(),
                                    payment.getReservation().getRoom().getName(),
                                    payment.getReservation().getRoom().getType(),
                                    payment.getReservation().getRoom().getReserveType(),
                                    payment.getReservation().getRoom().getDescription(),
                                    payment.getReservation().getRoom().getPrice(),
                                    payment.getReservation().getRoom().getFacilities()
//                                    payment.getReservation().getRoom().getFile()
                            ),
                            payment.getReservation().getCheckInDate(),
                            payment.getReservation().getCheckOutDate(),
                            payment.getReservation().getUser(),
                            payment.getReservation().getStatus()
                    ),
                    payment.getPrice(),
                    payment.getStatus()
            ));
        });
        return dtoList;
    }

    @Override
    public long getTotalPayments() {
        return paymentRepository.getTotalIPayment();
    }
}

package lk.ijse.hotelbackend.service;

import lk.ijse.hotelbackend.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    PaymentDto findPaymentService(String id);
    boolean savePaymentService(PaymentDto paymentDto);
    List<PaymentDto> getAllPaymentService();
    long getTotalPayments();
}

package lk.ijse.hotelbackend.repository;

import lk.ijse.hotelbackend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    @Query("SELECT count(i.id) FROM Payment i")
    long getTotalIPayment();
}

package lk.ijse.hotelbackend.repository;

import lk.ijse.hotelbackend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
    @Query(value = "select * from room where id  NOT IN(select distinct room_id from reservation where checkInDate between  ?1 AND  ?2 && checkOutDate between ?1 AND  ?2 ", nativeQuery = true)
    List<Reservation> findRoomIsReserve(String d1,String d2);

    @Query("SELECT count(i.id) FROM Reservation i")
    long getTotalItems();
}

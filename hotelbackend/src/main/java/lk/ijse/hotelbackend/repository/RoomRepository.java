package lk.ijse.hotelbackend.repository;

import lk.ijse.hotelbackend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,String> {
    @Query("SELECT count(i.id) FROM Room i")
    long getTotalItems();

    @Query(value = "SELECT * FROM Room where type=:type", nativeQuery = true)
    List<Room> findType(@Param("type") String type);
}

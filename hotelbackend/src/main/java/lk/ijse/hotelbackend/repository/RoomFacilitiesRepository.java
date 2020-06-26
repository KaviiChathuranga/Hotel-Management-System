package lk.ijse.hotelbackend.repository;

import lk.ijse.hotelbackend.entity.RoomFacilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomFacilitiesRepository extends JpaRepository<RoomFacilities,Integer> {
    @Query("SELECT count(i.id) FROM RoomFacilities i")
    long getTotalfacilitiesList();
}

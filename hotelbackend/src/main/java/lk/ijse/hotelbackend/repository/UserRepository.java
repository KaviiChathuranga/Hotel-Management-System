package lk.ijse.hotelbackend.repository;

import lk.ijse.hotelbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}

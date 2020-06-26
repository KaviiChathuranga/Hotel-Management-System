package lk.ijse.hotelbackend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class RoomFacilities {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Room room;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Facilities>facilitiesList;

    public RoomFacilities() {
    }

    public RoomFacilities(int id,Room room, List<Facilities> facilitiesList) {
        this.id = id;
        this.room = room;
        this.facilitiesList = facilitiesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Facilities> getFacilitiesList() {
        return facilitiesList;
    }

    public void setFacilitiesList(List<Facilities> facilitiesList) {
        this.facilitiesList = facilitiesList;
    }

    @Override
    public String toString() {
        return "RoomFacilitiesService{" +
                "id=" + id +
                ", room=" + room +
                ", facilitiesList=" + facilitiesList +
                '}';
    }
}

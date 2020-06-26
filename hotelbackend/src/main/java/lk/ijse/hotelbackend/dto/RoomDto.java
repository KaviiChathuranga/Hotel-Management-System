package lk.ijse.hotelbackend.dto;

import org.springframework.web.multipart.MultipartFile;

public class RoomDto {
    private String id;
    private String name;
    private String type;
    private String reserveType;
    private String description;
    private double price;
    private String facilities;
//    private MultipartFile file;

    public RoomDto(String id, String name, String type, String reserveType,String desc, double price,String facilities) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.reserveType = reserveType;
        this.price = price;
        this.description = desc;
        this.facilities=facilities;
//        this.file = file;
    }

    public RoomDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReserveType() {
        return reserveType;
    }

    public void setReserveType(String reserveType) {
        this.reserveType = reserveType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String desc){
        this.description = desc;
    }
    public String getDescription(){
        return this.description;
    }

    public void setFacilities(String facilities){
        this.facilities = facilities;
    }
    public String getFacilities(){
        return this.facilities;
    }

//    public void setFile(MultipartFile file){
//        this.file = file;
//    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", reserveType='" + reserveType + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", facilities='" + facilities + '\'' +
                '}';
    }
//    public MultipartFile getFile(){
//        return this.file;
//    }
}

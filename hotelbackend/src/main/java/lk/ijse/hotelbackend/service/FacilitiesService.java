package lk.ijse.hotelbackend.service;

import lk.ijse.hotelbackend.dto.FacilitiesDto;

import java.util.List;

public interface FacilitiesService {
    boolean saveFacilities(FacilitiesDto facilitiesDto);
    List<FacilitiesDto> getallFacilities();
}

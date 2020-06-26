package lk.ijse.hotelbackend.controller;

import lk.ijse.hotelbackend.dto.FacilitiesDto;
import lk.ijse.hotelbackend.service.FacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/facilities")
public class FacilitiesController {

    @Autowired
    private FacilitiesService facilitiesService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveFacilities(@RequestBody FacilitiesDto facilitiesDto){
        return facilitiesService.saveFacilities(facilitiesDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FacilitiesDto> getAllFacilities(){
        return facilitiesService.getallFacilities();
    }
}

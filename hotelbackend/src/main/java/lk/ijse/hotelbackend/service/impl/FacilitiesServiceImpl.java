package lk.ijse.hotelbackend.service.impl;

import lk.ijse.hotelbackend.dto.FacilitiesDto;
import lk.ijse.hotelbackend.entity.Facilities;
import lk.ijse.hotelbackend.repository.FacilitiesRepository;
import lk.ijse.hotelbackend.service.FacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class FacilitiesServiceImpl implements FacilitiesService {

    @Autowired
    private FacilitiesRepository facilitiesRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveFacilities(FacilitiesDto facilitiesDto) {
        try {
            facilitiesRepository.save(new Facilities(facilitiesDto.getId(),facilitiesDto.getName(),facilitiesDto.getPrice()));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<FacilitiesDto> getallFacilities() {
        List<Facilities> all = facilitiesRepository.findAll();
        List<FacilitiesDto>dtoList=new ArrayList<>();
        all.forEach(facilities -> {
            dtoList.add(new FacilitiesDto(facilities.getId(),facilities.getName(),facilities.getPrice()));
        });
        return dtoList;
    }
}

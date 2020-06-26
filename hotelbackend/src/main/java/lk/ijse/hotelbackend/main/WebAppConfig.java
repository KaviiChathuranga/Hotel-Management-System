package lk.ijse.hotelbackend.main;

import lk.ijse.hotelbackend.controller.RoomController;
import lk.ijse.hotelbackend.repository.FacilitiesRepository;
import lk.ijse.hotelbackend.repository.RoomFacilitiesRepository;
import lk.ijse.hotelbackend.repository.RoomRepository;
import lk.ijse.hotelbackend.repository.UserRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("lk.ijse.hotelbackend")
@EnableJpaRepositories(basePackageClasses = {RoomRepository.class,
        FacilitiesRepository.class,
        RoomFacilitiesRepository.class,
        UserRepository.class})
public class WebAppConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}

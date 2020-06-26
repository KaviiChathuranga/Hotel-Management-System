package lk.ijse.hotelbackend.controller;
import lk.ijse.hotelbackend.dto.PaymentDto;
import lk.ijse.hotelbackend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PaymentDto> getAllPayment(){
        return paymentService.getAllPaymentService();
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public PaymentDto findPayment(@PathVariable("id") String id){
        // System.out.println("Id is  :  "+id);
        return paymentService.findPaymentService(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean savePayment(@RequestBody PaymentDto paymentDto){
        //  System.out.println(" id:  "+roomDto.getId()+" name:  "+roomDto.getName()+" price:  "+roomDto.getPrice()+" desc:  "+roomDto.getDescription()+" reserve type:  "+roomDto.getReserveType()+" type:  "+roomDto.getType()
        // );
        System.out.println("savePayment : ");
        return paymentService.savePaymentService(paymentDto);
    }
    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalPayment(){
        return paymentService.getTotalPayments();
    }
}

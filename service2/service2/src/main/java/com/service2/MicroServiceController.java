package com.service2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class MicroServiceController {


    @GetMapping( value = "check1")
    public String micro1(){
        return "service2 api receviced success";
    }

    @GetMapping( value = "data")
    public List<String> data(){

        List<String> paymentTypes = Arrays.asList("netBanking","CashOnDelivery","BioMetric","UPI");
        return paymentTypes;
    }


    @PostMapping("product")
    public ResponseEntity<?> pData(@RequestBody Object object){
        if (object!=null){
            return ResponseEntity.ok("data reached");
        }else {
            return ResponseEntity.badRequest().body("not not reachesd ");
        }

    }



}

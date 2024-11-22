package com.service2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicroServiceController {


    @GetMapping( value = "check1")
    public String micro1(){
        return "service2 api receviced success";
    }


}

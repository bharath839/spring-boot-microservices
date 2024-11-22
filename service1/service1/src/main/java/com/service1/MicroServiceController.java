package com.service1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/api")
public class MicroServiceController {


    @GetMapping( "check")
    public String micro1(){
        return "service1 api receviced success";
    }


}

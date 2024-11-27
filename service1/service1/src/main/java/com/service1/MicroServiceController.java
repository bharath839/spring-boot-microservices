package com.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( value = "/api")
public class MicroServiceController {


    @Autowired
    private RestTemplate restTemplate;




    @GetMapping( "check")
    public String micro1(){
        return "service1 api receviced success";
    }


    @GetMapping("fetchServ2")
    public List<String> getFromService2(){
    String url="http://localhost:8001/data";

       List<String>data = restTemplate.getForObject(url, ArrayList.class);
        return data;
    }


    @GetMapping("data")
    public ResponseEntity<?> getThirdPartyData(){
        String url="https://dummyjson.com/products";
        Object da=restTemplate.getForObject(url, Object.class);
        return ResponseEntity.ok(da);
    }



    @PostMapping("category")
    public ResponseEntity<String> sendCategory(@RequestBody Category category) {
        String externalApiUrl = "http://localhost:8001/product";

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Category> request = new HttpEntity<>(category, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    externalApiUrl,
                    HttpMethod.POST,
                    request,
                    String.class
            );
            return ResponseEntity.ok(response.getBody());
        } catch (RestClientException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error sending data to external API: " + e.getMessage());
        }
    }
}

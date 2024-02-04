package ser.hkrn.gatewayservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class BusinessController {

    private final RestTemplate restTemplate;

    public BusinessController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/business")
    public ResponseEntity<?> getBusinessVersion() {
        return ResponseEntity.ok(
                restTemplate.getForObject("http://business-service/resolve/version", Object.class)
        );
    }
}

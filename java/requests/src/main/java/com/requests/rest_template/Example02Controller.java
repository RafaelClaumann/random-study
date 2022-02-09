package com.requests.rest_template;

import com.requests.rest_template.model.Vehicle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.UUID;

@RestController
@RequestMapping("example02")
public class Example02Controller {

    private final Example02Service example02Service;

    public Example02Controller(Example02Service example02Service) {
        this.example02Service = example02Service;
    }

    @GetMapping("forEntity")
    public ResponseEntity<String> callPostForEntityService() {
        this.example02Service.doPostForEntityEmptyBodyLocalhost();
        return ResponseEntity.ok("Performing POST(forEntity) on Example02Controller with RestTemplate");
    }

    @GetMapping("/forObject")
    public ResponseEntity<String> callPostForObjectService() {
        this.example02Service.doPostForObjectEmptyBodyLocalhost();
        return ResponseEntity.ok("Performing POST(forObject) on Example02Controller with RestTemplate");
    }

    @PostMapping
    public ResponseEntity<Vehicle> post(@RequestBody Vehicle vehicle) {
        final Vehicle mockedVehicle = this.mockVehicleForPostReturn();
        return ResponseEntity.ok(mockedVehicle);
    }

    private Vehicle mockVehicleForPostReturn() {
        return Vehicle.builder()
                .vehicleUUID(UUID.fromString("1bd0d423-67cb-44f5-b114-d8eb312993c5"))
                .vehicleID(2184L)
                .makeAndModel("Buick Encore")
                .fuelType("Ethanol")
                .carOptions(Arrays.asList("Airbag: Side", "Rear Window Wiper", "Cruise Control"))
                .color("Grey")
                .licensePlate("DGK-2603")
                .build();
    }

}

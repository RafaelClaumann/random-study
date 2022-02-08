package com.requests.rest_template.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"vehicleID", "vehicleUUID", "makeAndModel", "licensePlate"})
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
// @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Vehicle {

    @JsonProperty("uid")
    private UUID vehicleUUID;

    @JsonProperty("id")
    private Long vehicleID;

    @JsonProperty("make_and_model")
    private String makeAndModel;

    @JsonProperty("fuel_type")
    private String fuelType;

    @JsonProperty("car_options")
    private List<String> carOptions;

    private String color;

    @JsonProperty("license_plate")
    private String licensePlate;

}

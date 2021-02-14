package com.project.carrental.entity;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id", updatable=false, nullable=false)
    private Integer vehicleID;

    @Column(name = "make", length=50, nullable=false)
    private String make;

    @Column(name = "model", length=50, nullable=false)
    private String model;

    @Column(name = "autoGearbox", nullable=false)
    private Boolean autoGearbox;

    @Column(name = "air_conditioner", nullable=false)
    private Boolean airConditioner;

    @Column(name = "seats", nullable=false)
    private Integer seats;

    @Column(name = "daily_price", nullable=false)
    private BigDecimal dailyPrice;

    /**
     * Methods that generates the string representation of vehicle object to be
     * shown on the web page
     *
     * @return specially built string for representing vehicle on web page
     */
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(make).append(" ").append(model);
        if (autoGearbox) {
            sb.append(", Auto");
        } else {
            sb.append(", Manual");
        }
        if (airConditioner) {
            sb.append(", A/C");
        }
        sb.append(", $").append(dailyPrice).append("/day");
        return sb.toString();
    }
}

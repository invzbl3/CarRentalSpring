package com.project.carrental.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id", updatable=false, nullable=false)
    private int vehicleID;

    @Column(name = "make", length=50, nullable=false)
    private String make;

    @Column(name = "model", length=50, nullable=false)
    private String model;

    @Column(name = "autoGearbox", nullable=false)
    private boolean autoGearbox;

    @Column(name = "air_conditioner", nullable=false)
    private boolean airConditioner;

    @Column(name = "seats", nullable=false)
    private int seats;

    @Column(name = "daily_price", nullable=false)
    private BigDecimal dailyPrice;

    public Vehicle() {
    }

    public Vehicle(int vehicleID, String make, String model,
                   boolean autoGearbox, boolean airConditioner,
                   int seats, BigDecimal dailyPrice) {
        this.vehicleID = vehicleID;
        this.make = make;
        this.model = model;
        this.autoGearbox = autoGearbox;
        this.airConditioner = airConditioner;
        this.seats = seats;
        this.dailyPrice = dailyPrice;
    }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("vehicleID", vehicleID)
                .append("make", make)
                .append("model", model)
                .append("autoGearbox", autoGearbox)
                .append("airConditioner", airConditioner)
                .append("seats", seats)
                .append("dailyPrice", dailyPrice)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(vehicleID)
                .append(make)
                .append(model)
                .append(autoGearbox)
                .append(airConditioner)
                .append(seats)
                .append(dailyPrice)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        return new EqualsBuilder()
                .append(vehicleID, other.vehicleID)
                .append(make, other.make)
                .append(model, other.model)
                .append(autoGearbox, other.autoGearbox)
                .append(airConditioner, other.airConditioner)
                .append(seats, other.seats)
                .append(dailyPrice, other.dailyPrice)
                .isEquals();
    }
}

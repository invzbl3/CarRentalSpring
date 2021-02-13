package com.project.carrental.entity;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", updatable = false, nullable = false)
    private Integer orderID;

    @OneToOne
    //@Column(name = "vehicle_id", nullable = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @OneToOne
    //@Column(name = "user_id", nullable = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    //@Column(name = "passport_id", nullable = false)
    @JoinColumn(name = "passport_id", nullable = false)
    private Passport passport;

    @Column(name = "pick_up_date", nullable = false)
    private Timestamp pickUpDate;

    @Column(name = "drop_off_date", nullable = false)
    private Timestamp dropOffDate;

    @Column(name = "rent_cost", nullable = false)
    private BigDecimal rentCost;

    @Column(name = "processed", nullable = false)
    private Boolean processed = false;

    @Column(name = "rejected", nullable = false)
    private Boolean rejected = false;

    @Column(name = "reject_desc")
    private String rejectDesc;

    @Column(name = "picked", nullable = false)
    private Boolean picked = false;

    @Column(name = "returned", nullable = false)
    private Boolean returned = false;

    @Column(name = "damaged", nullable = false)
    private Boolean damaged = false;

    @Column(name = "damage_desc")
    private String damageDesc;

    @Column(name = "damage_cost")
    private BigDecimal damageCost;

    @Column(name = "paid", nullable = false)
    private Boolean paid = false;

    public Order() {
    }

    public Order(Integer orderID, Vehicle vehicle, User user, Passport passport,
                 Timestamp pickUpDate, Timestamp dropOffDate, BigDecimal rentCost,
                 Boolean processed, Boolean rejected, String rejectDesc,
                 Boolean picked, Boolean returned, Boolean damaged,
                 String damageDesc, BigDecimal damageCost, Boolean paid) {
        this.orderID = orderID;
        this.vehicle = vehicle;
        this.user = user;
        this.passport = passport;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.rentCost = rentCost;
        this.processed = processed;
        this.rejected = rejected;
        this.rejectDesc = rejectDesc;
        this.picked = picked;
        this.returned = returned;
        this.damaged = damaged;
        this.damageDesc = damageDesc;
        this.damageCost = damageCost;
        this.paid = paid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("orderID", orderID)
                .append("vehicle", vehicle)
                .append("user", user)
                .append("passport", passport)
                .append("pickUpDate", pickUpDate)
                .append("dropOffDate", dropOffDate)
                .append("rentCost", rentCost)
                .append("processed", processed)
                .append("rejected", rejected)
                .append("rejectDesc", rejectDesc)
                .append("picked", picked)
                .append("returned", returned)
                .append("damaged", damaged)
                .append("damageDesc", damageDesc)
                .append("damageCost", damageCost)
                .append("paid", paid)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(orderID)
                .append(vehicle)
                .append(user)
                .append(passport)
                .append(pickUpDate)
                .append(dropOffDate)
                .append(rentCost)
                .append(processed)
                .append(rejected)
                .append(rejectDesc)
                .append(picked)
                .append(returned)
                .append(damaged)
                .append(damageDesc)
                .append(damageCost)
                .append(paid)
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
        final Order other = (Order) obj;
        return new EqualsBuilder()
                .append(orderID, other.orderID)
                .append(vehicle, other.vehicle)
                .append(user, other.user)
                .append(passport, other.passport)
                .append(pickUpDate, other.pickUpDate)
                .append(dropOffDate, other.dropOffDate)
                .append(rentCost, other.rentCost)
                .append(processed, other.processed)
                .append(rejected, other.rejected)
                .append(rejectDesc, other.rejectDesc)
                .append(picked, other.picked)
                .append(returned, other.returned)
                .append(damaged, other.damaged)
                .append(damageDesc, other.damageDesc)
                .append(damageCost, other.damageCost)
                .append(paid, other.paid)
                .isEquals();
    }
}
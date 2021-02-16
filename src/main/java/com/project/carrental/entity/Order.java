package com.project.carrental.entity;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
}
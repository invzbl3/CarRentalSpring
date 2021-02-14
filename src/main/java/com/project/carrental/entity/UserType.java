package com.project.carrental.entity;

import lombok.*;
import javax.persistence.*;

@Data
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity(name="usertypes")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usertype_id", updatable=false, nullable=false)
    private Integer usertypeID;

    @Column(name = "usertype", length=50, nullable=false)
    private String usertype;
}

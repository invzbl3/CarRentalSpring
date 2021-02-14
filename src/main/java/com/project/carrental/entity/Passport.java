package com.project.carrental.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Data
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@Entity(name="passports")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id", updatable = false, nullable = false)
    private Integer passportID;

    @Column(name = "last_name", length=50, nullable = false)
    private String lastName;

    @Column(name = "first_name", length=50, nullable = false)
    private String firstName;

    @Column(name = "patronymic", length=50)
    private String patronymic;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "p_series", length=2, nullable = false)
    private String passportSeries;

    @Column(name = "p_number", length=6, nullable = false)
    private String passportNumber;

    @Column(name = "who_issued", length=50, nullable = false)
    private String whoIssued;

    @Column(name = "when_issued", nullable = false)
    private Date whenIssued;

    /**
     * Methods that generates the string representation of passport object to be
     * shown on the web page
     *
     * @return specially built string for representing passport on web page
     */
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(lastName).append(" ").append(firstName).append("\n");
        if (patronymic != null) {
            sb.append(patronymic).append("\n");
        }
        sb.append(birthday).append("\n");
        sb.append(passportSeries).append(passportNumber).append("\n");
        sb.append(whoIssued).append(" ").append(whenIssued);
        return sb.toString();
    }
}
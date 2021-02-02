package com.project.carrental.entity;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id", updatable = false, nullable = false)
    private int passportID;

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

    public Passport() {
    }

    public Passport(int passportID, String lastName, String firstName,
                    String patronymic, Date birthday, String passportSeries,
                    String passportNumber, String whoIssued, Date whenIssued) {
        this.passportID = passportID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.whoIssued = whoIssued;
        this.whenIssued = whenIssued;
    }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("passportID", passportID)
                .append("lastName", lastName)
                .append("firstName", firstName)
                .append("patronymic", patronymic)
                .append("birthday", birthday)
                .append("passportSeries", passportSeries)
                .append("passportNumber", passportNumber)
                .append("whoIssued", whoIssued)
                .append("whenIssued", whenIssued)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(passportID)
                .append(lastName)
                .append(firstName)
                .append(patronymic)
                .append(birthday)
                .append(passportSeries)
                .append(passportNumber)
                .append(whoIssued)
                .append(whenIssued)
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
        final Passport other = (Passport) obj;
        return new EqualsBuilder()
                .append(passportID, other.passportID)
                .append(lastName, other.lastName)
                .append(firstName, other.firstName)
                .append(patronymic, other.patronymic)
                .append(birthday, other.birthday)
                .append(passportSeries, other.passportSeries)
                .append(passportNumber, other.passportNumber)
                .append(whoIssued, other.whoIssued)
                .append(whenIssued, other.whenIssued)
                .isEquals();
    }
}
package com.project.carrental.entity;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable=false, nullable=false)
    private int userID;

    @Column(name = "usertype_id", nullable=false)
    private int userTypeID;

    @Column(name = "login", length=50, nullable=false)
    private String login;

    @Column(name = "password", length=50, nullable=false)
    private String password;

    public User() {
    }

    public User(int userID, int userTypeID, String login, String password) {
        this.userID = userID;
        this.userTypeID = userTypeID;
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("userID", userID)
                .append("userTypeID", userTypeID)
                .append("login", login)
                .append("password", "****")
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(userID)
                .append(userTypeID)
                .append(login)
                .append(password)
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
        final User other = (User) obj;
        return new EqualsBuilder()
                .append(userID, other.userID)
                .append(userTypeID, other.userTypeID)
                .append(login, other.login)
                .append(password, other.password)
                .isEquals();
    }
}

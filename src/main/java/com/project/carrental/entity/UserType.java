package com.project.carrental.entity;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import javax.persistence.*;

@Data
@Entity
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usertype_id", updatable=false, nullable=false)
    private Integer usertypeID;

    @Column(name = "usertype", length=50, nullable=false)
    private String usertype;

    public UserType() {
    }

    public UserType(Integer usertypeID, String usertype) {
        this.usertypeID = usertypeID;
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("usertypeID", usertypeID)
                .append("usertype", usertype)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(usertypeID)
                .append(usertype)
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
        final UserType other = (UserType) obj;
        return new EqualsBuilder()
                .append(usertypeID, other.usertypeID)
                .append(usertype, other.usertype)
                .isEquals();
    }
}

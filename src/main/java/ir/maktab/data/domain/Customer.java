package ir.maktab.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer extends Users {
    @Column
    private String userName;

    public String getUserName() {
        return userName;
    }

    public Customer setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}

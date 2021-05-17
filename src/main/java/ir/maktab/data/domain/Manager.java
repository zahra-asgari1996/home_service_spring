package ir.maktab.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Manager extends Users {
    @Column
    private String userName;

    public String getUserName() {
        return userName;
    }

    public Manager setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}

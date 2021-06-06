package ir.maktab.dto;

import ir.maktab.data.enums.UserRole;
import ir.maktab.data.enums.UserSituation;

import java.util.Date;

public class UserDto {
    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private UserSituation userSituation;
    private Date date;
    private UserRole userRole;
    private Double credit;

    public UserDto() {
        this.credit=0.0;
        this.userSituation = UserSituation.New;
    }

    public Integer getId() {
        return id;
    }

    public UserRole getRole() {
        return userRole;
    }

    public UserDto setRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    public UserDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserSituation getSituation() {
        return userSituation;
    }

    public UserDto setSituation(UserSituation userSituation) {
        this.userSituation = userSituation;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public UserDto setDate(Date date) {
        this.date = date;
        return this;
    }

    public Double getCredit() {
        return credit;
    }

    public UserDto setCredit(Double credit) {
        this.credit = credit;
        return this;
    }



}

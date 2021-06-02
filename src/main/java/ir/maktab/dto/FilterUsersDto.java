package ir.maktab.dto;

import ir.maktab.data.enums.Role;

public class FilterUsersDto {
    private String name;
    private String lastName;
    private Role role;
    private String email;
    private Integer rate;
    private String field;

    public String getName() {
        return name;
    }

    public FilterUsersDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public FilterUsersDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public FilterUsersDto setRole(Role role) {
        this.role = role;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public FilterUsersDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getRate() {
        return rate;
    }

    public FilterUsersDto setRate(Integer rate) {
        this.rate = rate;
        return this;
    }

    public String getField() {
        return field;
    }

    public FilterUsersDto setField(String field) {
        this.field = field;
        return this;
    }
}

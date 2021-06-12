package ir.maktab.dto;


import ir.maktab.service.validation.LoginValidation;
import ir.maktab.service.validation.RegisterValidation;
import ir.maktab.service.validation.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ManagerDto {
    private Integer id;
    @NotBlank(message = "User Name Can Not Be Null!")
    @Size(min = 2, max = 10, message = "Size Should Be Between 2 And 10!")
    private String userName;
    @ValidPassword
    private String password;

    public Integer getId() {
        return id;
    }

    public ManagerDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public ManagerDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ManagerDto setPassword(String password) {
        this.password = password;
        return this;
    }
}

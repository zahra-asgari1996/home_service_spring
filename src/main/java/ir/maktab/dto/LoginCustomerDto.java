package ir.maktab.dto;

public class LoginCustomerDto {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public LoginCustomerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginCustomerDto setPassword(String password) {
        this.password = password;
        return this;
    }
}

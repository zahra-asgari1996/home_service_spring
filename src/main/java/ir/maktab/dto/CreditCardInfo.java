package ir.maktab.dto;

import javax.validation.constraints.*;
import java.util.Date;

public class CreditCardInfo {
    @NotBlank(message = "Card Number Can Not Be Null !")
    @Pattern(regexp = "[1-9][0-9]{15}")
    private String creditNumber;
    @NotBlank(message = "Password Can Not Be Null !")
    @Pattern(regexp = "[0-9]{5}")
    private String password;
    @NotBlank(message = "Expire Date Can Not Be Null !")
    @Pattern(regexp ="^(0[1-9]|1[0-2])/?([0-9]{2})$")
    private String expireDate;
    @NotBlank(message = "CVV2 Can Not Be Null !")
    @Pattern(regexp = "[0-9]{4}")
    private String cvv2;
    @NotBlank(message = "Captcha CAn Not Be Null !")
    private String captcha;

    public String getCreditNumber() {
        return creditNumber;
    }

    public CreditCardInfo setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CreditCardInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public CreditCardInfo setExpireDate(String expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public String getCvv2() {
        return cvv2;
    }

    public CreditCardInfo setCvv2(String cvv2) {
        this.cvv2 = cvv2;
        return this;
    }

    public String getCaptcha() {
        return captcha;
    }

    public CreditCardInfo setCaptcha(String captcha) {
        this.captcha = captcha;
        return this;
    }
}

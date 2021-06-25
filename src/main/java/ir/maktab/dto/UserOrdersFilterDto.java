package ir.maktab.dto;

import ir.maktab.data.enums.OfferSituation;
import ir.maktab.data.enums.OrderSituation;
import ir.maktab.data.enums.UserRole;
import ir.maktab.service.validation.LoginValidation;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserOrdersFilterDto {
    private Integer userId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endDate;
    private OrderSituation situation;
    private Double maxOfferPrice;
    private Double minOfferPrice;
    @NotNull(message = "checkBox")
    private UserRole role;

    public Integer getUserId() {
        return userId;
    }

    public UserOrdersFilterDto setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public UserOrdersFilterDto setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public UserOrdersFilterDto setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public OrderSituation getSituation() {
        return situation;
    }

    public UserOrdersFilterDto setSituation(OrderSituation situation) {
        this.situation = situation;
        return this;
    }

    public Double getMaxOfferPrice() {
        return maxOfferPrice;
    }

    public UserOrdersFilterDto setMaxOfferPrice(Double maxOfferPrice) {
        this.maxOfferPrice = maxOfferPrice;
        return this;
    }

    public Double getMinOfferPrice() {
        return minOfferPrice;
    }

    public UserOrdersFilterDto setMinOfferPrice(Double minOfferPrice) {
        this.minOfferPrice = minOfferPrice;
        return this;
    }

    public UserRole getRole() {
        return role;
    }

    public UserOrdersFilterDto setRole(UserRole role) {
        this.role = role;
        return this;
    }
}

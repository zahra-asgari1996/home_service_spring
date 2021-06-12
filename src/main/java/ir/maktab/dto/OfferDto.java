package ir.maktab.dto;

import ir.maktab.data.domain.Expert;
import ir.maktab.data.domain.Orders;
import ir.maktab.data.enums.OfferSituation;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class OfferDto {
    private Integer id;
    private OrderDto orders;
    private Date SubmitOffer;
    @NotNull(message = "Offer Price Can Not Be Null !")
    private Double offerPrice;
    @Max(value = 600, message = "Time Of Work Can Not Be More Than 600 Minutes !")
    @Min(value = 20, message = "Time Of Work Can Not Be Less Than 20 Minutes !")
    private Long durationOfWork;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startTime;
    private ExpertDto expert;
    private OfferSituation offerSituation;

    public OfferDto() {
        this.offerSituation=OfferSituation.registered;
    }

    public Integer getId() {
        return id;
    }

    public OfferDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public OfferSituation getOfferSituation() {
        return offerSituation;
    }

    public OfferDto setOfferSituation(OfferSituation offerSituation) {
        this.offerSituation = offerSituation;
        return this;
    }

    public Date getSubmitOffer() {
        return SubmitOffer;
    }

    public OfferDto setSubmitOffer(Date submitOffer) {
        SubmitOffer = submitOffer;
        return this;
    }

    public Double getOfferPrice() {
        return offerPrice;
    }

    public OfferDto setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
        return this;
    }

    public Long getDurationOfWork() {
        return durationOfWork;
    }

    public OfferDto setDurationOfWork(Long durationOfWork) {
        this.durationOfWork = durationOfWork;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public OfferDto setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public OrderDto getOrders() {
        return orders;
    }

    public OfferDto setOrders(OrderDto orders) {
        this.orders = orders;
        return this;
    }

    public ExpertDto getExpert() {
        return expert;
    }

    public OfferDto setExpert(ExpertDto expert) {
        this.expert = expert;
        return this;
    }
}

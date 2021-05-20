package ir.maktab.dto;

import ir.maktab.data.domain.Expert;
import ir.maktab.data.domain.Orders;
import jdk.jfr.Timestamp;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class OfferDto {
    private Integer id;
    private Orders orders;
    private Date SubmitOffer;
    private Double offerPrice;
    private Double durationOfWork;
    private Date startTime;
    private Expert expert;

    public Integer getId() {
        return id;
    }

    public OfferDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Orders getOrders() {
        return orders;
    }

    public OfferDto setOrders(Orders orders) {
        this.orders = orders;
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

    public Double getDurationOfWork() {
        return durationOfWork;
    }

    public OfferDto setDurationOfWork(Double durationOfWork) {
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

    public Expert getExpert() {
        return expert;
    }

    public OfferDto setExpert(Expert expert) {
        this.expert = expert;
        return this;
    }
}

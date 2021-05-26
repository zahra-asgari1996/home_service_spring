package ir.maktab.dto;

import ir.maktab.data.domain.Expert;
import ir.maktab.data.domain.Orders;
import ir.maktab.data.enums.OfferSituation;
import jdk.jfr.Timestamp;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class OfferDto {
    private Integer id;
    private OrderDto orders;
    private Date SubmitOffer;
    private Double offerPrice;
    private Double durationOfWork;
    private Date startTime;
    private ExpertDto expert;
    private OfferSituation offerSituation;

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

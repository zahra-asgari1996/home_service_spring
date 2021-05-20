package ir.maktab.dto;

import ir.maktab.data.domain.Customer;
import ir.maktab.data.domain.Offers;
import ir.maktab.data.domain.SubService;
import ir.maktab.data.enums.OrderSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDto {
    private Integer id;
    private Double proposedPrice;
    private String jobDescription;
    private Date dateOfOrderRegistration;
    private Date dateOfWork;
    private OrderSituation situation;
    private Customer customer;
    private SubService subService;
    private List<Offers> offers=new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public OrderDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getProposedPrice() {
        return proposedPrice;
    }

    public OrderDto setProposedPrice(Double proposedPrice) {
        this.proposedPrice = proposedPrice;
        return this;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public OrderDto setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
        return this;
    }

    public Date getDateOfOrderRegistration() {
        return dateOfOrderRegistration;
    }

    public OrderDto setDateOfOrderRegistration(Date dateOfOrderRegistration) {
        this.dateOfOrderRegistration = dateOfOrderRegistration;
        return this;
    }

    public Date getDateOfWork() {
        return dateOfWork;
    }

    public OrderDto setDateOfWork(Date dateOfWork) {
        this.dateOfWork = dateOfWork;
        return this;
    }

    public OrderSituation getSituation() {
        return situation;
    }

    public OrderDto setSituation(OrderSituation situation) {
        this.situation = situation;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderDto setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public SubService getSubService() {
        return subService;
    }

    public OrderDto setSubService(SubService subService) {
        this.subService = subService;
        return this;
    }

    public List<Offers> getOffers() {
        return offers;
    }

    public OrderDto setOffers(List<Offers> offers) {
        this.offers = offers;
        return this;
    }
}

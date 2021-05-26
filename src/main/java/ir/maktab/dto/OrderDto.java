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
    private CustomerDto customer;
    private SubServiceDto subService;
    private List<OfferDto> offers=new ArrayList<>();

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

    public CustomerDto getCustomer() {
        return customer;
    }

    public OrderDto setCustomer(CustomerDto customer) {
        this.customer = customer;
        return this;
    }

    public SubServiceDto getSubService() {
        return subService;
    }

    public OrderDto setSubService(SubServiceDto subService) {
        this.subService = subService;
        return this;
    }

    public List<OfferDto> getOffers() {
        return offers;
    }

    public OrderDto setOffers(List<OfferDto> offers) {
        this.offers = offers;
        return this;
    }
}

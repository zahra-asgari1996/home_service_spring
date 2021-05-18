package ir.maktab.data.domain;

import ir.maktab.data.enums.OrderSituation;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double proposedPrice;
    private String jobDescription;
    private Date dateOfOrderRegistration;
    private Date dateOfWork;
    private OrderSituation situation;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private SubService subService;
//    @ManyToOne
//    private Expert expert;

    public Integer getId() {
        return id;
    }

    public Orders setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getProposedPrice() {
        return proposedPrice;
    }

    public Orders setProposedPrice(Double proposedPrice) {
        this.proposedPrice = proposedPrice;
        return this;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public Orders setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
        return this;
    }

    public Date getDateOfOrderRegistration() {
        return dateOfOrderRegistration;
    }

    public Orders setDateOfOrderRegistration(Date dateOfOrderRegistration) {
        this.dateOfOrderRegistration = dateOfOrderRegistration;
        return this;
    }

    public Date getDateOfWork() {
        return dateOfWork;
    }

    public Orders setDateOfWork(Date dateOfWork) {
        this.dateOfWork = dateOfWork;
        return this;
    }

    public OrderSituation getSituation() {
        return situation;
    }

    public Orders setSituation(OrderSituation situation) {
        this.situation = situation;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Orders setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public SubService getSubService() {
        return subService;
    }

    public Orders setSubService(SubService subService) {
        this.subService = subService;
        return this;
    }

//    public Expert getExpert() {
//        return expert;
//    }
//
//    public Orders setExpert(Expert expert) {
//        this.expert = expert;
//        return this;
//    }
}

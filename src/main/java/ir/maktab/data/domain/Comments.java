package ir.maktab.data.domain;

import org.springframework.jmx.export.annotation.ManagedAttribute;

import javax.persistence.*;

@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Expert expert;
    @Column
    private String comment;
    @Column
    private Double rate;


    private Orders order;


    //order ro biyar

    public Integer getId() {
        return id;
    }

    public Comments setId(Integer id) {
        this.id = id;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Comments setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Expert getExpert() {
        return expert;
    }

    public Comments setExpert(Expert expert) {
        this.expert = expert;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Comments setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Double getRate() {
        return rate;
    }

    public Comments setRate(Double rate) {
        this.rate = rate;
        return this;
    }
}

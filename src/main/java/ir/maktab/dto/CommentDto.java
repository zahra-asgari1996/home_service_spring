package ir.maktab.dto;

import ir.maktab.data.domain.Customer;
import ir.maktab.data.domain.Expert;


public class CommentDto {
    private Integer id;
    private Customer customer;
    private Expert expert;
    private String comment;
    private Double rate;

    public Integer getId() {
        return id;
    }

    public CommentDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CommentDto setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Expert getExpert() {
        return expert;
    }

    public CommentDto setExpert(Expert expert) {
        this.expert = expert;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public CommentDto setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Double getRate() {
        return rate;
    }

    public CommentDto setRate(Double rate) {
        this.rate = rate;
        return this;
    }
}

package ir.maktab.dto;

import ir.maktab.data.domain.Comments;
import ir.maktab.data.domain.Offers;
import ir.maktab.data.domain.SubService;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class ExpertDto extends UserDto{
    private Integer rate;
    private byte[] image;
    private List<SubService> services=new ArrayList<>();
    private List<Offers> offers=new ArrayList<>();
    private List<Comments> comments=new ArrayList<>();

    public Integer getRate() {
        return rate;
    }

    public ExpertDto setRate(Integer rate) {
        this.rate = rate;
        return this;
    }

    public byte[] getImage() {
        return image;
    }

    public ExpertDto setImage(byte[] image) {
        this.image = image;
        return this;
    }

    public List<SubService> getServices() {
        return services;
    }

    public ExpertDto setServices(List<SubService> services) {
        this.services = services;
        return this;
    }

    public List<Offers> getOffers() {
        return offers;
    }

    public ExpertDto setOffers(List<Offers> offers) {
        this.offers = offers;
        return this;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public ExpertDto setComments(List<Comments> comments) {
        this.comments = comments;
        return this;
    }
}

package ir.maktab.data.domain;

import ir.maktab.data.enums.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Expert extends Users {
    @Column
    private Integer rate;
    @Lob
    @Column(columnDefinition="BLOB",length =300000)
    private byte[] image;
    @ManyToMany
    private List<SubService> services=new ArrayList<>();
    @OneToMany(mappedBy = "expert")
    private List<Offers> offers=new ArrayList<>();
    @OneToMany(mappedBy = "expert")
    private List<Comments> comments=new ArrayList<>();

    public Expert() {
        this.setRole(Role.Expert);
    }


    public Integer getRate() {
        return rate;
    }

    public Expert setRate(Integer rate) {
        this.rate = rate;
        return this;
    }

    public byte[] getImage() {
        return image;
    }

    public Expert setImage(byte[] image) {
        this.image = image;
        return this;
    }

    public List<SubService> getServices() {
        return services;
    }

    public Expert setServices(List<SubService> services) {
        this.services = services;
        return this;
    }

    public List<Offers> getOffers() {
        return offers;
    }

    public Expert setOffers(List<Offers> offers) {
        this.offers = offers;
        return this;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public Expert setComments(List<Comments> comments) {
        this.comments = comments;
        return this;
    }
}

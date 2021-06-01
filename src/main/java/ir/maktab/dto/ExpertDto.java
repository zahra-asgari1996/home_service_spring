package ir.maktab.dto;

import ir.maktab.data.domain.Comments;
import ir.maktab.data.domain.Offers;
import ir.maktab.data.domain.SubService;
import ir.maktab.data.enums.Role;
import ir.maktab.data.enums.Situation;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class ExpertDto extends UserDto{
    private Integer rate;
    private byte[] image;
    private List<SubServiceDto> services=new ArrayList<>();
    private List<OfferDto> offers=new ArrayList<>();
    private List<CommentDto> comments=new ArrayList<>();
    private List<OrderDto> orders=new ArrayList<>();

    public ExpertDto() {
        super.setCredit(0.0);
        super.setRole(Role.Expert);
        super.setSituation(Situation.New);
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public ExpertDto setOrders(List<OrderDto> orders) {
        this.orders = orders;
        return this;
    }

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

    public List<SubServiceDto> getServices() {
        return services;
    }

    public ExpertDto setServices(List<SubServiceDto> services) {
        this.services = services;
        return this;
    }

    public List<OfferDto> getOffers() {
        return offers;
    }

    public ExpertDto setOffers(List<OfferDto> offers) {
        this.offers = offers;
        return this;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public ExpertDto setComments(List<CommentDto> comments) {
        this.comments = comments;
        return this;
    }
}

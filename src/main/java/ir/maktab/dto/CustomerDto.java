package ir.maktab.dto;

import ir.maktab.data.domain.Comments;
import ir.maktab.data.domain.Orders;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class CustomerDto extends UserDto{
    private List<Orders> orders=new ArrayList<>();
    private List<Comments> comments=new ArrayList<>();

    public List<Orders> getOrders() {
        return orders;
    }

    public CustomerDto setOrders(List<Orders> orders) {
        this.orders = orders;
        return this;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public CustomerDto setComments(List<Comments> comments) {
        this.comments = comments;
        return this;
    }
}

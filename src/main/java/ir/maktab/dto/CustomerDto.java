package ir.maktab.dto;

import ir.maktab.data.domain.Comments;
import ir.maktab.data.domain.Orders;
import ir.maktab.data.enums.Role;
import ir.maktab.data.enums.Situation;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class CustomerDto extends UserDto{
    private List<OrderDto> orders=new ArrayList<>();
    private List<CommentDto> comments=new ArrayList<>();

    public CustomerDto() {
        super.setCredit(0.0);
        super.setRole(Role.Customer);
        super.setSituation(Situation.New);
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public CustomerDto setOrders(List<OrderDto> orders) {
        this.orders = orders;
        return this;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public CustomerDto setComments(List<CommentDto> comments) {
        this.comments = comments;
        return this;
    }
}

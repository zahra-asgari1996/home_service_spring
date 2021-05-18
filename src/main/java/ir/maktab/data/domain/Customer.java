package ir.maktab.data.domain;

import ir.maktab.data.enums.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends Users {

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders=new ArrayList<>();
}

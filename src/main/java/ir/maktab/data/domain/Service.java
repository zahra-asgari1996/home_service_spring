package ir.maktab.data.domain;

import ir.maktab.data.enums.TypeOfService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "Type_Of_Service")
//@DiscriminatorValue(value = "Service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated
    private TypeOfService type;
    @Column
    private String name;
    @OneToMany
    private List<SubService> subServices=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubService> getSubServices() {
        return subServices;
    }

    public void setSubServices(List<SubService> subServices) {
        this.subServices = subServices;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeOfService getType() {
        return type;
    }

    public void setType(TypeOfService type) {
        this.type = type;
    }
}

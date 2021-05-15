package ir.maktab.data.domain;

import ir.maktab.data.enums.TypeOfService;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Of_Service")
@DiscriminatorValue(value = "Service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated
    private TypeOfService type;

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

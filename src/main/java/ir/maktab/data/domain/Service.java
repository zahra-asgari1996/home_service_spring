package ir.maktab.data.domain;

import ir.maktab.data.enums.TypeOfService;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated
    private TypeOfService type;


}

package ir.maktab.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SubService extends Service{
    @Column
    private Double basePrice;
    @Column
    private String description;
    @Column
    private String name;
}

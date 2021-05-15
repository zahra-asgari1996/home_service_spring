package ir.maktab.data.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Sub_Service")
public class SubService extends Service{
    @Column
    private Double basePrice;
    @Column
    private String description;
    @Column
    private String name;
}

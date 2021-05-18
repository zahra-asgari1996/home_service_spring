package ir.maktab.data.domain;

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
//    @OneToMany(mappedBy = "expert")
//    private List<Orders> orders=new ArrayList<>();
    @OneToMany(mappedBy = "expert")
    private List<Offers> offers=new ArrayList<>();

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

}

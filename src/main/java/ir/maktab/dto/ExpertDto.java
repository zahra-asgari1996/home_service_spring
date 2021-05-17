package ir.maktab.dto;

import ir.maktab.data.domain.SubService;

import java.util.ArrayList;
import java.util.List;

public class ExpertDto extends UserDto{
    private Integer rate;
    private byte[] image;
    private List<SubService> services=new ArrayList<>();

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

    public List<SubService> getServices() {
        return services;
    }

    public ExpertDto setServices(List<SubService> services) {
        this.services = services;
        return this;
    }
}

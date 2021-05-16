package ir.maktab.dto;

import ir.maktab.data.domain.SubService;
import ir.maktab.data.enums.TypeOfService;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class ServiceDto {
    private Integer id;
    private String name;
    private List<SubService> subServices=new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}

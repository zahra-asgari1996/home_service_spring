package ir.maktab.dto;

import ir.maktab.data.domain.Service;


public class SubServiceDto {
    private Integer id;
    private Double basePrice;
    private String description;
    private String name;
    private ServiceDto service;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceDto getService() {
        return service;
    }

    public SubServiceDto setService(ServiceDto service) {
        this.service = service;
        return this;
    }
}

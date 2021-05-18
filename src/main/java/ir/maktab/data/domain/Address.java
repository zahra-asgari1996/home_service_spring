package ir.maktab.data.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String street;
    private String alley;
    private String plaque;

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getAlley() {
        return alley;
    }

    public Address setAlley(String alley) {
        this.alley = alley;
        return this;
    }

    public String getPlaque() {
        return plaque;
    }

    public Address setPlaque(String plaque) {
        this.plaque = plaque;
        return this;
    }
}

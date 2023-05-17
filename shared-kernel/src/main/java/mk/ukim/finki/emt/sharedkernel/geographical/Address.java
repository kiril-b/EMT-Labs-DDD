package mk.ukim.finki.emt.sharedkernel.geographical;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.ValueObject;

import java.util.Objects;

@Embeddable
@Getter
public class Address implements ValueObject {

    private final String country;

    private final String city;

    private final String street;

    private final String number;


    public Address(String country, String city, String street, String number) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public Address() {
        this.country = "";
        this.city = "";
        this.street = "";
        this.number = "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(number, address.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, street, number);
    }
}

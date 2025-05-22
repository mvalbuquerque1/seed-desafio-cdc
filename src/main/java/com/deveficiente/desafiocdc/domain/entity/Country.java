package com.deveficiente.desafiocdc.domain.entity;

import com.deveficiente.desafiocdc.domain.dto.CountryRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<State> state;

    public static Country toCountry(CountryRequest countryRequest) {
        Country country = new Country();
        country.setName(countryRequest.getName());
        return country;
    }
}

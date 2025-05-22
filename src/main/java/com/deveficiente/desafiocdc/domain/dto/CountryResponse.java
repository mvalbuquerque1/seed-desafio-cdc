package com.deveficiente.desafiocdc.domain.dto;

import com.deveficiente.desafiocdc.domain.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountryResponse {

    private Long id;

    private String name;

    public static CountryResponse toCountryResponse(Country country) {
        CountryResponse countryResponse = new CountryResponse();
        countryResponse.setId(country.getId());
        countryResponse.setName(country.getName());
        return countryResponse;
    }
}

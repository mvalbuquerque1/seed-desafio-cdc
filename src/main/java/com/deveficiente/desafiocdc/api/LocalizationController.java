package com.deveficiente.desafiocdc.api;

import com.deveficiente.desafiocdc.domain.dto.CountryRequest;
import com.deveficiente.desafiocdc.domain.dto.CountryResponse;
import com.deveficiente.desafiocdc.domain.dto.StateRequest;
import com.deveficiente.desafiocdc.domain.dto.StateResponse;
import com.deveficiente.desafiocdc.domain.entity.Country;
import com.deveficiente.desafiocdc.domain.entity.State;
import com.deveficiente.desafiocdc.repository.CountryRepository;
import com.deveficiente.desafiocdc.repository.StateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/localization")
public class LocalizationController {

    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;

    public LocalizationController(CountryRepository countryRepository, StateRepository stateRepository) {
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
    }

    @PostMapping(path = "/country")
    public ResponseEntity<CountryResponse> saveCountry(@RequestBody CountryRequest countryRequest) {
        Country savedCountry = countryRepository.save(Country.toCountry(countryRequest));
        CountryResponse response = CountryResponse.toCountryResponse(savedCountry);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/state")
    public ResponseEntity<?> saveState(@RequestBody StateRequest stateRequest) {
        Optional<Country> optionalCountry = countryRepository.findById(stateRequest.getCountryId());

        if (optionalCountry.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Country not found"));
        }

        Country country = optionalCountry.get();
        State savedState = stateRepository.save(State.toState(stateRequest, country));
        StateResponse stateResponse = StateResponse.toStateResponse(savedState);
        return ResponseEntity.ok(stateResponse);
    }
}

package com.deveficiente.desafiocdc.domain.entity;

import com.deveficiente.desafiocdc.domain.dto.StateRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "state")
@Getter
@Setter
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public static State toState(StateRequest stateRequest, Country countryToTest) {
        State state = new State();
        state.setName(stateRequest.getName());
        state.setCountry(countryToTest);
        return state;
    }

}

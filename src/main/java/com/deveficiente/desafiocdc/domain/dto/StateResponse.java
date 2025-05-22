package com.deveficiente.desafiocdc.domain.dto;

import com.deveficiente.desafiocdc.domain.entity.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateResponse {

    private Long id;
    private String name;
    private String countryName;

    public static StateResponse toStateResponse(State state) {
        StateResponse stateResponse = new StateResponse();
        stateResponse.setId(state.getId());
        stateResponse.setCountryName(state.getCountry().getName());
        stateResponse.setName(state.getName());
        return stateResponse;
    }
}

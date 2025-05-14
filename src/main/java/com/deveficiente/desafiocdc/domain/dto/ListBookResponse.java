package com.deveficiente.desafiocdc.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ListBookResponse {

    private Long id;
    private String title;
}

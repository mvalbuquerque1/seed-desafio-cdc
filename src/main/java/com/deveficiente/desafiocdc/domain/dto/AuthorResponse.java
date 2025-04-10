package com.deveficiente.desafiocdc.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AuthorResponse {

    @NotNull
    private Long id;
    @NotEmpty(message = "Name must not to be null")
    private String name;
    @NotEmpty(message = "Email must not to be null")
    @Email
    private String email;
    @NotEmpty(message = "Description must not to be null")
    @Size(max = 400)
    private String description;

    public AuthorResponse() {
    }

    public AuthorResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

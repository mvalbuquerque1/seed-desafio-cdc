package com.deveficiente.desafiocdc.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class AuthorRequest {

    @NotEmpty(message = "Name must not to be null")
    private String name;
    @NotEmpty(message = "Email must not to be null")
    @Email
    private String email;
    @NotEmpty(message = "Description must not to be null")
    @Size(max = 400)
    private String description;

    public AuthorRequest() {
    }

    public AuthorRequest(String name, String email) {
        this.name = name;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AuthorRequest that = (AuthorRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}

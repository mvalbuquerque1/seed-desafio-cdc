package com.deveficiente.desafiocdc.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name must not to be null")
    private String name;
    @Email
    @NotEmpty(message = "Email must not to be null")
    private String email;
    @NotEmpty(message = "Description must not to be null")
    @Size(max = 400)
    private String description;

    @NotNull
    private LocalDateTime createdAt;

    public Author(String name, String email, LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(email, author.email) && Objects.equals(createdAt, author.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, createdAt);
    }
}

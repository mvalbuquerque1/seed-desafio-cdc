package com.deveficiente.desafiocdc.domain.dto;

import com.deveficiente.desafiocdc.domain.entity.Category;
import com.deveficiente.desafiocdc.util.UniqueValue;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

public class CategoryRequest {

    @NotEmpty(message = "Name must not be null")
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CategoryRequest that = (CategoryRequest) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

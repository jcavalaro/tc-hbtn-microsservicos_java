package com.example.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;

    protected String code;

    protected String name;

    protected String description;

    protected BigDecimal price;

    protected LocalDateTime createdOne;

    protected boolean status;

    public Product() {
    }

    public Product(Long id, String code, String name, String description, BigDecimal price, LocalDateTime createdOne, boolean status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdOne = createdOne;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return status == product.status && Objects.equals(id, product.id) && Objects.equals(code, product.code) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(createdOne, product.createdOne);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, description, price, createdOne, status);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreatedOne() {
        return createdOne;
    }

    public void setCreatedOne(LocalDateTime createdOne) {
        this.createdOne = createdOne;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

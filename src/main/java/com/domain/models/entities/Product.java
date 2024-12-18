package com.domain.models.entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_product")
public class Product implements Serializable {

    private final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @NotEmpty(message = "Name is required!")
    @Column(name = "name")
    private String name;
    private String description;
    private double price;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(name = "product_suplier", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "suplier_id"))
    private Set<Suplier> supliers;

    public Product() {
    }

    public Set<Suplier> getSupliers() {
        return supliers;
    }

    public void setSupliers(Set<Suplier> supliers) {
        this.supliers = supliers;
    }

    public Product(long iD, String name, String description, double price) {
        ID = iD;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getID() {
        return ID;
    }

    public void setID(long iD) {
        ID = iD;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}

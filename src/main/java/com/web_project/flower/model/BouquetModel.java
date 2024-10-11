package com.web_project.flower.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "bouquets")
public class BouquetModel {
    @Id
    @GeneratedValue
    private UUID Id;
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String Name;
    @Size(min = 3, message = "Описание не менее 3 символов")
    private String Description;
    @Size(min = 3, message = "Цена не менее 3 символов")
    private String Price;
    @Nullable
    private String Paper;

//    @OneToMany(mappedBy = "bouquet", cascade = CascadeType.ALL)
//    private List<BouquetClientModel> bouquetClient;

    @ManyToOne
    @JoinColumn(name = "flower_id")
    private FlowerModel flower;

//    @ManyToOne
//    @JoinColumn(name = "bouquet_id")
//    private BouquetClientModel bouquetClient;


    public BouquetModel(){}


    public BouquetModel(UUID id, String name, String description, String price, @Nullable String paper, FlowerModel flower) {
        Id = id;
        Name = name;
        Description = description;
        Price = price;
        Paper = paper;
        this.flower = flower;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getName() {
        return Name;
    }

    public void setName(@Size(min = 3, message = "Имя не менее 3 символов") String name) {
        Name = name;
    }

    public @Size(min = 3, message = "Описание не менее 3 символов") String getDescription() {
        return Description;
    }

    public void setDescription(@Size(min = 3, message = "Описание не менее 3 символов") String description) {
        Description = description;
    }

    public @Size(min = 3, message = "Цена не менее 3 символов") String getPrice() {
        return Price;
    }

    public void setPrice(@Size(min = 3, message = "Цена не менее 3 символов") String price) {
        Price = price;
    }

    @Nullable
    public String getPaper() {
        return Paper;
    }

    public void setPaper(@Nullable String paper) {
        Paper = paper;
    }

    public FlowerModel getFlower() {
        return flower;
    }

    public void setFlower(FlowerModel flower) {
        this.flower = flower;
    }
}

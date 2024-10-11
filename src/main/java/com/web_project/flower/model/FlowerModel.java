package com.web_project.flower.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "flowers")
public class FlowerModel {
    @Id
    @GeneratedValue
    private UUID Id;
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String Name;
    @Size(min = 3, message = "Описание не менее 3 символов")
    private String Color;


    @OneToMany(mappedBy = "flower", cascade = CascadeType.ALL)
    private List<BouquetModel> bouquet;



    public FlowerModel(){}

    public FlowerModel(UUID id, String name, String color, List<BouquetModel> bouquet) {
        Id = id;
        Name = name;
        Color = color;
        this.bouquet = bouquet;
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

    public @Size(min = 3, message = "Описание не менее 3 символов") String getColor() {
        return Color;
    }

    public void setColor(@Size(min = 3, message = "Описание не менее 3 символов") String color) {
        Color = color;
    }

    public List<BouquetModel> getBouquet() {
        return bouquet;
    }

    public void setBouquet(List<BouquetModel> bouquet) {
        this.bouquet = bouquet;
    }
}

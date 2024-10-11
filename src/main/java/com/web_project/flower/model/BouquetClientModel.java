package com.web_project.flower.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "bouquetClients")
public class BouquetClientModel {
    @Id
    @GeneratedValue
    private UUID Id;
    @Nullable
    private String FLower1;
    @Nullable
    private String FLower2;
    @Nullable
    private String FLower3;
    @Nullable
    private String FLower4;
    @Nullable
    private String Paper;


//    @OneToMany(mappedBy = "bouquetClient", cascade = CascadeType.ALL)
//    private List<BouquetModel> bouquet;

//    @ManyToOne
//    @JoinColumn(name = "bouquetClient_id")
//    private BouquetModel bouquet;


//    @ManyToMany
//    @JoinTable(name = "bouquetClient_order",
//            joinColumns = @JoinColumn(name = "bouquetClient_id"),
//            inverseJoinColumns = @JoinColumn(name = "order_id"))
//    private List<OrderModel> orders;

//    @OneToMany(mappedBy = "bouquetClient", cascade = CascadeType.ALL)
//    private List<OrderModel> orders;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private OrderModel order;


    @OneToMany(mappedBy = "bouquetClient", cascade = CascadeType.ALL)
    private List<OrderModel> order;

    public BouquetClientModel(){}


    public BouquetClientModel(UUID id, @Nullable String FLower1, @Nullable String FLower2, @Nullable String FLower3, @Nullable String FLower4, @Nullable String paper, List<OrderModel> order) {
        Id = id;
        this.FLower1 = FLower1;
        this.FLower2 = FLower2;
        this.FLower3 = FLower3;
        this.FLower4 = FLower4;
        Paper = paper;
        this.order = order;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @Nullable
    public String getFLower1() {
        return FLower1;
    }

    public void setFLower1(@Nullable String FLower1) {
        this.FLower1 = FLower1;
    }

    @Nullable
    public String getFLower2() {
        return FLower2;
    }

    public void setFLower2(@Nullable String FLower2) {
        this.FLower2 = FLower2;
    }

    @Nullable
    public String getFLower3() {
        return FLower3;
    }

    public void setFLower3(@Nullable String FLower3) {
        this.FLower3 = FLower3;
    }

    @Nullable
    public String getFLower4() {
        return FLower4;
    }

    public void setFLower4(@Nullable String FLower4) {
        this.FLower4 = FLower4;
    }

    @Nullable
    public String getPaper() {
        return Paper;
    }

    public void setPaper(@Nullable String paper) {
        Paper = paper;
    }

    public List<OrderModel> getOrder() {
        return order;
    }

    public void setOrder(List<OrderModel> order) {
        this.order = order;
    }
}

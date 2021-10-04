package com.example.demoSul.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table (name = "warehouse")
public class Warehouse {
    @Id
    @Column (name = "id_part_number")
    private Long idPartNumber;

    @Column (name = "category")
    private String category;

    @Column (name = "product_name")
    private String productName;

    @Column (name = "description")
    private String description;

    @Column (name = "size")
    private String size;

    @Column (name = "price")
    private Long price;

    @Column (name = "quantity")
    private Long quantity;

    @Column (name = "id_delivery_note")
    private Long idDeliveryNote;

    @OneToMany (mappedBy = "warehouse", fetch = FetchType.LAZY)
    private Set<Favorite> favorite;
}

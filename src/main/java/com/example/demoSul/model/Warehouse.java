package com.example.demoSul.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @Column(name = "id_part_number")
    @ApiModelProperty("Сгенерированный артикул товара")
    private Long idPartNumber;

    @Column(name = "category")
    @ApiModelProperty("Катерогия товара")
    private String category;

    @Column(name = "product_name")
    @ApiModelProperty("Ниаменование товара")
    private String productName;

    @Column(name = "description")
    @ApiModelProperty("Описание товара")
    private String description;

    @Column(name = "size")
    @ApiModelProperty("Размер")
    private String size;

    @Column(name = "price")
    @ApiModelProperty("Цена")
    private Long price;

    @Column(name = "quantity")
    @ApiModelProperty("Количество на складе")
    private Long quantity;

    @Column(name = "id_delivery_note")
    @ApiModelProperty("Номер накладной доставки товара")
    private Long idDeliveryNote;

    @OneToMany(mappedBy = "warehouse", fetch = FetchType.LAZY)
    private Set<Favorite> favorite;
}

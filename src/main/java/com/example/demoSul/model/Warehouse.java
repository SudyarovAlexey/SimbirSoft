package com.example.demoSul.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table (name = "warehouse")
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность Склад")
public class Warehouse {
    @Id
    @Column (name = "id_part_number")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long idPartNumber;

    @Column (name = "category")
    @Schema(description = "Категория товара")
    private String category;

    @Column (name = "product_name")
    @Schema(description = "Наименование товара")
    private String productName;

    @Column (name = "description")
    @Schema(description = "Описание товара")
    private String description;

    @Column (name = "size")
    @Schema(description = "Размер товара")
    private String size;

    @Column (name = "price")
    @Schema(description = "Цена товара")
    private Long price;

    @Column (name = "quantity")
    @Schema(description = "Количество на складе")
    private Long quantity;

    @Column (name = "id_delivery_note")
    @Schema(description = "Номер накладной поставки на склад")
    private Long idDeliveryNote;

    @OneToMany (mappedBy = "warehouse", orphanRemoval = true)
    private Set<Favorite> favorite;
}

package com.example.demoSul.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table (name = "favorite")
@Schema(description = "Сущность избранное")
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {
    @Id
    @Column (name = "id_customer")
    @Schema(description = "Внешний ключ - id покупателя")
    private Long idCustomer;

    @Column (name = "id_part_number", insertable = false, updatable = false)
    @Schema(description = "Внешний ключ - id товара")
    private Long idPartNumber;

    @ManyToOne
    @JoinColumn(name="customer", insertable = false, updatable = false, referencedColumnName = "id_customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="warehouse", referencedColumnName = "id_part_number")
    private Warehouse warehouse;
}

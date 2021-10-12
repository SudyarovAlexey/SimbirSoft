package com.example.demoSul.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "favorite")
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {
    @Id
    @Column(name = "id_customer")
    @ApiModelProperty("id покупателя - внешний ключ")
    private Long idCustomer;

    @Column(name = "id_part_number")
    @ApiModelProperty("Артикул товара - внешний ключ")
    private Long idPartNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_part_number", insertable = false, updatable = false)
    private Warehouse warehouse;
}

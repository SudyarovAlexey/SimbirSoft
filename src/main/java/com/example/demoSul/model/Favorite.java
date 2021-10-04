package com.example.demoSul.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table (name = "favorite")
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {
    @Id
    @Column (name = "id_customer")
    private Long idCustomer;

    @Column (name = "id_part_number")
    private Long idPartNumber;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="id_customer", nullable=false, insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="id_part_number", nullable=false, insertable = false, updatable = false)
    private Warehouse warehouse;
}

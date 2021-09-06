package com.example.demoSul.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "favorites")
public class Favorites {
        @ForeignKey
        @Column (name = "id_customer")
        private Long idCustomer;

        @Column (name = "id_part_number")
        private String idPartNumber;

}

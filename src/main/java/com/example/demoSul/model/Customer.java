package com.example.demoSul.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table (name = "customer")
public class Customer  {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    @Column (name = "id_customer")
    private Long idCustomer;

    @Column (name = "name_customer")
    private String nameCustomer;

    @Column (name = "birthdate")
    private Date birthdate;

    @Column (name = "country")
    private String country;

    @Column (name = "address")
    private String address;

    @Column (name = "phone_customer")
    private String phoneCustomer;
}

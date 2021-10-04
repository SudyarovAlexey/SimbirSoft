package com.example.demoSul.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
@Table (name = "customer")
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany (mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Favorite> favorites;

}

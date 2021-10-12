package com.example.demoSul.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    @ApiModelProperty("Сгенерированный id товара")
    private Long idCustomer;

    @Column(name = "name_customer")
    @ApiModelProperty("Имя покупателя")
    private String nameCustomer;

    @Column(name = "birthdate")
    @ApiModelProperty("Дата рождения")
    private Date birthdate;

    @Column(name = "country")
    @ApiModelProperty("Страна")
    private String country;

    @Column(name = "address")
    @ApiModelProperty("Адрес")
    private String address;

    @Column(name = "phone_customer")
    @ApiModelProperty("Телефон")
    private String phoneCustomer;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Favorite> favorites;

}

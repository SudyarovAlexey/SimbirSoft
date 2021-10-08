package com.example.demoSul.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Сущность Покупатель")
public class Customer  {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    @Column (name = "id_customer")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long idCustomer;

    @Column (name = "name_customer")
    @Schema(description = "Фамилия Имя Отчество покупателя model")
    private String nameCustomer;

    @Column (name = "birthdate")
    @Schema(description = "Дата рождения покупателя")
    private Date birthdate;

    @Column (name = "country")
    @Schema(description = "Страна проживания покупателя")
    private String country;

    @Column (name = "address")
    @Schema(description = "Адрес проживания покупателя")
    private String address;

    @Column (name = "phone_customer")
    @Schema(description = "Номер телефона покупателя")
    private String phoneCustomer;

    @OneToMany (mappedBy = "customer", orphanRemoval = true)
    private Set<Favorite> favorite;
}

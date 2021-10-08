package com.example.demoSul.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.sql.Date;

@Getter
@Setter
@Schema(description = "Сущность Покупатель")
public class CustomerDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long idCustomer;
    @Schema(description = "Фамилия Имя Отчество покупателя")
    private String nameCustomer;
    @Schema(description = "Дата рождения покупателя")
    private Date birthdate;
    @Schema(description = "Страна проживания покупателя")
    private String country;
    @Schema(description = "Адрес проживания покупателя")
    private String address;
    @Schema(description = "Номер телефона покупателя")
    private String phoneCustomer;
}



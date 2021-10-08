package com.example.demoSul.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@Schema(description = "Сущность Товар")
public class WarehouseDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long idPartNumber;
    @Schema(description = "Категория товара")
    private String category;
    @Schema(description = "Наименование товара")
    private String productName;
    @Schema(description = "Описание товара")
    private String description;
    @Schema(description = "Размер товара")
    private String size;
    @Schema(description = "Цена товара")
    private Long price;
    @Schema(description = "Количество на складе")
    private Long quantity;
    @Schema(description = "Номер накладной поставки на склад")
    private Long idDeliveryNote;
}



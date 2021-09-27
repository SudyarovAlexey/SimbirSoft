package com.example.demoSul.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
public class WarehouseDTO {
    private Long idPartNumber;
    private String category;
    private String productName;
    private String description;
    private String size;
    private Long price;
    private Long quantity;
    private Long idDeliveryNote;
}



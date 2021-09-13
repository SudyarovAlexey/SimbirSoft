package com.example.demoSul.dto;

import lombok.*;
import java.sql.Date;

@Getter
@Setter
public class CustomerDTO {
    private Long idCustomer;
    private String nameCustomer;
    private Date birthdate;
    private String country;
    private String address;
    private String phoneCustomer;
}

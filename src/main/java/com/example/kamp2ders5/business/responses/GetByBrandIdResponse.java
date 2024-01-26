package com.example.kamp2ders5.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByBrandIdResponse {
    private int id;
    private String name;
}

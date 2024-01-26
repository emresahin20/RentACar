package com.example.kamp2ders5.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public  class GetAllModelsResponse {
    private int id;
    private String name;
    private String brandName;
}

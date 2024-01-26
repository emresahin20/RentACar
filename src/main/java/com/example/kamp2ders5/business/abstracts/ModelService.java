package com.example.kamp2ders5.business.abstracts;

import com.example.kamp2ders5.business.requests.CreateBrandRequest;
import com.example.kamp2ders5.business.requests.CreateModelRequest;
import com.example.kamp2ders5.business.responses.GetAllBrandsResponse;
import com.example.kamp2ders5.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}

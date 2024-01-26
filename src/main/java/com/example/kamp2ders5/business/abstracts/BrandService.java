package com.example.kamp2ders5.business.abstracts;

import com.example.kamp2ders5.business.requests.CreateBrandRequest;
import com.example.kamp2ders5.business.requests.UpdateBrandRequest;
import com.example.kamp2ders5.business.responses.GetAllBrandsResponse;
import com.example.kamp2ders5.business.responses.GetByBrandIdResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse>getAll();
    GetByBrandIdResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}

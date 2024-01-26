package com.example.kamp2ders5.webApi.controller;

import com.example.kamp2ders5.business.abstracts.BrandService;
import com.example.kamp2ders5.business.requests.CreateBrandRequest;
import com.example.kamp2ders5.business.requests.UpdateBrandRequest;
import com.example.kamp2ders5.business.responses.GetAllBrandsResponse;
import com.example.kamp2ders5.business.responses.GetByBrandIdResponse;
import com.example.kamp2ders5.entities.Brand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse>getAll(){
        return brandService.getAll();
    }
    @GetMapping("/{id}")
    public GetByBrandIdResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public  void add(@RequestBody() @Valid CreateBrandRequest createBrandRequest){
        brandService.add(createBrandRequest);
    }
    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}

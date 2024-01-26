package com.example.kamp2ders5.business.concretes;

import com.example.kamp2ders5.business.abstracts.BrandService;
import com.example.kamp2ders5.business.requests.CreateBrandRequest;
import com.example.kamp2ders5.business.requests.UpdateBrandRequest;
import com.example.kamp2ders5.business.responses.GetAllBrandsResponse;
import com.example.kamp2ders5.business.responses.GetByBrandIdResponse;
import com.example.kamp2ders5.business.rules.BrandBusinessRules;
import com.example.kamp2ders5.core.utilities.mappers.ModelMapperService;
import com.example.kamp2ders5.dataAccess.abstracts.BrandRepository;
import com.example.kamp2ders5.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        /*List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
        for (Brand brand : brands) {
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponse.add(responseItem);*/
        List<GetAllBrandsResponse> brandsResponse = brands.stream().
                map(brand -> this.modelMapperService.
                        forResponse().map(brand, GetAllBrandsResponse.class)).
                collect(Collectors.toList());
        return brandsResponse;
    }

    @Override
    public GetByBrandIdResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByBrandIdResponse response = this.modelMapperService.forResponse().
                map(brand, GetByBrandIdResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        // Brand brand = new Brand();
        //brand.setName(createBrandRequest.getName());
        this.brandBusinessRules.checkIfBrandNameExist(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().
                map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().
                map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}

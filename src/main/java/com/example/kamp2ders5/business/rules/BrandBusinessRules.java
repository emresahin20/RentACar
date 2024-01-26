package com.example.kamp2ders5.business.rules;

import com.example.kamp2ders5.core.utilities.exceptions.BusinessException;
import com.example.kamp2ders5.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExist(String name){
        if (this.brandRepository.existsByName(name));
            throw new BusinessException("Brand name already exists");
    }
}

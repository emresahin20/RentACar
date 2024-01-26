package com.example.kamp2ders5.dataAccess.abstracts;

import com.example.kamp2ders5.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand,Integer> {

    boolean existsByName(String name);

}

package com.example.kamp2ders5.dataAccess.abstracts;

import com.example.kamp2ders5.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}

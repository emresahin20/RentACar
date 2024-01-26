package com.example.kamp2ders5.business.concretes;

import com.example.kamp2ders5.business.abstracts.ModelService;
import com.example.kamp2ders5.business.requests.CreateModelRequest;
import com.example.kamp2ders5.business.responses.GetAllBrandsResponse;
import com.example.kamp2ders5.business.responses.GetAllModelsResponse;
import com.example.kamp2ders5.core.utilities.mappers.ModelMapperService;
import com.example.kamp2ders5.dataAccess.abstracts.ModelRepository;
import com.example.kamp2ders5.entities.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponse = models.stream().
                map(model -> this.modelMapperService.forResponse().
                        map(model, GetAllModelsResponse.class)).
                collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
    this.modelRepository.save(model);
    }
}

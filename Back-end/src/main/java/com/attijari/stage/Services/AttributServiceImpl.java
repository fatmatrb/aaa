package com.attijari.stage.Services;

import com.attijari.stage.Entity.Attributs;
import com.attijari.stage.Repository.AttributRepository;
import com.attijari.stage.Repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.attijari.stage.Entity.Module;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AttributServiceImpl implements AttributService {
    @Autowired
    private AttributRepository attributsRepository;
    @Autowired
    private ModuleRepository moduleRepository;

    public List<Attributs> findAllWithModule() {
        return attributsRepository.findAllWithModule();
    }

    @Override
    public Attributs addAttributsAssociateToModule(Attributs attribut, Long idModule) {
        Module module = moduleRepository.findById(idModule).get();
        attribut.setModule(module);
        return attributsRepository.save(attribut);
    }

    @Override
    public Attributs updateAttribut(Attributs attributs, Long id) {
        Attributs existingAttributs = attributsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Attributs with ID " + id + " not found"));

        Module newModule = attributs.getModule();
        if (newModule != null) {
            Module existingModel = moduleRepository.findById(newModule.getIdModule())
                    .orElseThrow(() -> new EntityNotFoundException("Model with ID " + newModule.getIdModule() + " not found"));
            existingAttributs.setModule(existingModel);
        }

        existingAttributs.setLibAttributs(attributs.getLibAttributs());
        existingAttributs.setNameAttributs(attributs.getNameAttributs());

        return attributsRepository.save(existingAttributs);
    }

    @Override
    public void deleteAttributs(Long id) {
        moduleRepository.deleteById(id);
    }

}


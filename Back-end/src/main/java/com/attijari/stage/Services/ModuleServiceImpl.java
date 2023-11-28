package com.attijari.stage.Services;
import com.attijari.stage.Entity.Module;
import com.attijari.stage.Repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService{
    @Autowired
    private ModuleRepository moduleRepository;


    @Override
    public Module saveModule(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    @Override
    public Module getModuleById(Long id) {
        return moduleRepository.findById(id).orElse(null);
    }

    @Override
    public Module updateModule(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}

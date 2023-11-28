package com.attijari.stage.Services;
import java.util.List;
import com.attijari.stage.Entity.Module;
public interface ModuleService {
    Module saveModule(Module module);
    List<Module> getAllModules();
    Module getModuleById(Long id);
    Module updateModule(Module module);
    void deleteModule(Long id);

}

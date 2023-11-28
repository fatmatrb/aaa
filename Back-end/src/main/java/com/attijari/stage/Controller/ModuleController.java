package com.attijari.stage.Controller;

import com.attijari.stage.Entity.Module;
import com.attijari.stage.Services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modules")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping
    public List<Module> getAllModules() {
        return moduleService.getAllModules();
    }

    @GetMapping("/{id}")
    public Module getModuleById(@PathVariable Long id) {
        return moduleService.getModuleById(id);
    }

    @PostMapping("/AddModule")
    public Module createModule(@RequestBody Module module) {
        return moduleService.saveModule(module);
    }
    @DeleteMapping("/DeleteModule/{id}")
    public void deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
    }

}

package com.attijari.stage.Controller;
import com.attijari.stage.Entity.Attributs;
import com.attijari.stage.Services.AttributService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/attributs")
public class AttributController {
    @Autowired
    private AttributService attributsService;

    @GetMapping("/All")
    public List<Attributs> getAllAttributsWithModules() {
        return attributsService.findAllWithModule();
    }
    @PostMapping("/AddAttribut/{idModule}")
    public Attributs addAttributsAssociateToModel(@RequestBody Attributs attribut, @PathVariable Long idModule) {
        return attributsService.addAttributsAssociateToModule(attribut, idModule );
    }
    @PutMapping("/UpdateAttribut/{id}")
    public ResponseEntity<Attributs> updateAttribut(@PathVariable Long id, @RequestBody Attributs attributs) {
        Attributs updatedAttributs = attributsService.updateAttribut(attributs, id);
        return ResponseEntity.ok(updatedAttributs);
    }
    @DeleteMapping("/deleletAttribut/{id}")
    public void deleteAttribut(@PathVariable Long id) {
        attributsService.deleteAttributs(id);
    }
}
package org.example.ccrut.controleur;


import org.example.ccrut.model.Controle;
import org.example.ccrut.repo.ControleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/controles")
public class ControleCont {
    @Autowired
    private ControleRepo controleRepository;

    @GetMapping
    public List<Controle> getAllControles() {
        return controleRepository.findAll();
    }

    @PostMapping
    public Controle addControle(@RequestBody Controle controle) {
        return controleRepository.save(controle);
    }

    @GetMapping("/{id}")
    public Controle getControleById(@PathVariable Integer id) {
        return controleRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteControle(@PathVariable Integer id) {
        controleRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Controle updateChecked(@PathVariable Integer id, @RequestBody Controle updatedControle) {
        Controle controle = controleRepository.findById(id).orElse(null);
        if (controle != null) {
            controle.setChecked(updatedControle.getChecked());
            return controleRepository.save(controle);
        }
        return null;
    }
    @GetMapping("/checklist/{checklistId}")
    public List<Controle> getControlesByChecklistId(@PathVariable Integer checklistId) {
        return controleRepository.findByChecklistId(checklistId);
    }

    // Méthode pour mettre à jour le checklistId
    @PutMapping("/updateChecklistId/{id}")
    public Controle updateChecklistId(@PathVariable Integer id, @RequestBody Integer checklistId) {
        Controle controle = controleRepository.findById(id).orElse(null);
        if (controle != null) {
            controle.setChecklistId(checklistId); // Mettre à jour checklistId
            return controleRepository.save(controle);
        }
        return null;
    }



}
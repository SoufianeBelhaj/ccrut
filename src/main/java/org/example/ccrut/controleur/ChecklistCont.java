package org.example.ccrut.controleur;

import org.example.ccrut.model.Checklist;
import org.example.ccrut.repo.ChecklistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/checklists")
public class ChecklistCont {

    @Autowired
    private ChecklistRepo checklistRepository;

    // Récupérer toutes les checklists
    @GetMapping
    public ResponseEntity<List<Checklist>> getAllChecklists() {
        List<Checklist> all = checklistRepository.findAll();
        return ResponseEntity.ok(all);
    }

    // Ajouter une nouvelle checklist
    @PostMapping
    public ResponseEntity<Checklist> addChecklist(@RequestBody Checklist checklist) {
        if (checklist == null) {
            return ResponseEntity.badRequest().build();
        }
        Checklist saved = checklistRepository.save(checklist);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Récupérer une checklist par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Checklist> getChecklistById(@PathVariable Integer id) {
        return checklistRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Supprimer une checklist par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChecklist(@PathVariable Integer id) {
        if (!checklistRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        checklistRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Mettre à jour une checklist par son ID
    @PutMapping("/{id}")
    public ResponseEntity<Checklist> updateChecklist(@PathVariable Integer id, @RequestBody Checklist checklist) {
        if (!checklistRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        checklist.setIdChecklists(id); // forcer l'ID à l'ID du path
        Checklist updated = checklistRepository.save(checklist);
        return ResponseEntity.ok(updated);
    }

    // Archiver une checklist (mettre archived à true)
    @PutMapping("/{id}/archive")
    public ResponseEntity<Checklist> archiveChecklist(@PathVariable Integer id) {
        return checklistRepository.findById(id).map(checklist -> {
            checklist.setArchived(true);
            Checklist saved = checklistRepository.save(checklist);
            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/archived")
    public ResponseEntity<List<Checklist>> getArchivedChecklists() {
        List<Checklist> archived = checklistRepository.findByArchivedTrue();
        return ResponseEntity.ok(archived);
    }
}

package org.example.ccrut.controleur;

import org.example.ccrut.model.Surveillance;
import org.example.ccrut.repo.SurveillanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/departements")
public class SurveillanceCont {
    @Autowired
    private SurveillanceRepo surveillanceRepository;

    @GetMapping
    public List<Surveillance> getAllSurveillances() {
        return surveillanceRepository.findAll();
    }

    @PostMapping
    public Surveillance addSurveillance(@RequestBody Surveillance surv) {
        return surveillanceRepository.save(surv);
    }

    @GetMapping("/{id}")
    public Surveillance getSurveillanceById(@PathVariable Integer id) {
        return surveillanceRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartement(@PathVariable Integer id) {
        surveillanceRepository.deleteById(id);
    }
}


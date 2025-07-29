package org.example.ccrut.repo;

import org.example.ccrut.model.Controle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ControleRepo extends JpaRepository<Controle, Integer> {
    List<Controle> findByChecklistId(Integer checklistId);

}
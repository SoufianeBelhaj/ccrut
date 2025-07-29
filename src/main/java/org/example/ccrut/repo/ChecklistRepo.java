package org.example.ccrut.repo;

import org.example.ccrut.model.Checklist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ChecklistRepo extends JpaRepository<Checklist, Integer> {
    List<Checklist> findByArchivedTrue();

}
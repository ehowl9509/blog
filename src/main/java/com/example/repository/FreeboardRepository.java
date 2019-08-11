package com.example.repository;


import com.example.model.Freeboard;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreeboardRepository extends JpaRepository<Freeboard, Long> {
    Freeboard findByFreeId(Long freeId);
}

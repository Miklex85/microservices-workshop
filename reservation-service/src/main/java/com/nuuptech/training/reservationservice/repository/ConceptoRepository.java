package com.nuuptech.training.reservationservice.repository;

import com.nuuptech.training.reservationservice.model.Concepto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptoRepository extends JpaRepository<Concepto, Long> {

    @Query("SELECT c FROM Concepto c ORDER BY c.id")
    Page<Concepto> findAll(Pageable pageable);

}

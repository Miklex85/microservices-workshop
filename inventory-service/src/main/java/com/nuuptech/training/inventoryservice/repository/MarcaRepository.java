package com.nuuptech.training.inventoryservice.repository;

import com.nuuptech.training.inventoryservice.model.Marca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

    @Query("SELECT m FROM Marca m ORDER BY m.id")
    Page<Marca> findAll(Pageable pageable);

}

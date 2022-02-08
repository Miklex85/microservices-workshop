package com.nuuptech.training.inventoryservice.repository;

import com.nuuptech.training.inventoryservice.model.Sucursal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

    @Query("SELECT s FROM Sucursal s ORDER BY s.id")
    Page<Sucursal> findAll(Pageable pageable);
}

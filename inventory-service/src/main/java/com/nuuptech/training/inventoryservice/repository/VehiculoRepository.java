package com.nuuptech.training.inventoryservice.repository;

import com.nuuptech.training.inventoryservice.model.Marca;
import com.nuuptech.training.inventoryservice.model.Sucursal;
import com.nuuptech.training.inventoryservice.model.Vehiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v FROM Vehiculo v WHERE v.marca.id = :marcaId ORDER BY v.id")
    Page<Vehiculo> findAllByMarca(@Param("marcaId") Long marcaId, Pageable pageable);

    @Query("SELECT v FROM Vehiculo v WHERE v.sucursal.id = :sucursalId ORDER BY v.id")
    Page<Vehiculo> findAllBySucursal(@Param("sucursalId") Long sucursalId, Pageable pageable);

    @Query("SELECT v FROM Vehiculo v WHERE v.marca.id = :marcaId AND v.sucursal.id = :sucursalId ORDER BY v.id")
    Page<Vehiculo> findAllByMarcaAndSucursal(@Param("marcaId") Long marcaId, @Param("sucursalId") Long sucursalId, Pageable pageable);
}

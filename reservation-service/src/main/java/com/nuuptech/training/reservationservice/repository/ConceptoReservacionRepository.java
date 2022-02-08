package com.nuuptech.training.reservationservice.repository;

import com.nuuptech.training.reservationservice.model.ConceptoReservacion;
import com.nuuptech.training.reservationservice.model.ConceptoReservacionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConceptoReservacionRepository extends JpaRepository<ConceptoReservacion, ConceptoReservacionId> {

    @Query("SELECT cr FROM ConceptoReservacion cr WHERE cr.id.reservacion.id = :reservacionId")
    List<ConceptoReservacion> findAllByReservacion(@Param("reservacionId") Long reservacionId);

    @Query("SELECT COUNT(cr) FROM ConceptoReservacion cr WHERE cr.id.reservacion.id = :reservacionId")
    int countByReservacion(@Param("reservacionId") Long reservacionId);

    @Query("DELETE FROM ConceptoReservacion cr WHERE cr.id.reservacion.id = :reservacionId")
    void deleteAllByReservacion(@Param("reservacionId") Long reservacionId);

}

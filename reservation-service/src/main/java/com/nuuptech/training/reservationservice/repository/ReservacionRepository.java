package com.nuuptech.training.reservationservice.repository;

import com.nuuptech.training.reservationservice.model.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservacionRepository extends JpaRepository<Reservacion, Long> {
}

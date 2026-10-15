package tn.esprit.aichadrira4cce11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aichadrira4cce11.domain.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}

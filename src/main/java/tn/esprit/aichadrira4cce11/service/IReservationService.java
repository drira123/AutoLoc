package tn.esprit.aichadrira4cce11.service;

import tn.esprit.aichadrira4cce11.domain.Reservation;
import java.util.List;

public interface IReservationService {
    Reservation create(Reservation reservation);
    Reservation update(Reservation reservation);
    Reservation findById(Long id);
    List<Reservation> findAll();
    void deleteById(Long id);
}
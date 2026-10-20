package tn.esprit.aichadrira4cce11.service;

import tn.esprit.aichadrira4cce11.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule create (Vehicule vehicule);

    Vehicule update(Long id, Vehicule vehicule);

    Vehicule findById(Vehicule vehicule);
    void deleteById(Long id);
    Vehicule findById(Long id);
    List<Vehicule> findAll();
}
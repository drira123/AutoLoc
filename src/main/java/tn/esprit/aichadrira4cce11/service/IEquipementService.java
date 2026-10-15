package tn.esprit.aichadrira4cce11.service;

import tn.esprit.aichadrira4cce11.domain.Equipement;
import java.util.List;

public interface IEquipementService {
    Equipement create(Equipement equipement);
    Equipement update(Equipement equipement);
    Equipement findById(Long id);
    List<Equipement> findAll();
    void deleteById(Long id);
}
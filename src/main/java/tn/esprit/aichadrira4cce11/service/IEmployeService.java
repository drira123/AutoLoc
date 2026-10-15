package tn.esprit.aichadrira4cce11.service;

import tn.esprit.aichadrira4cce11.domain.Employe;
import java.util.List;

public interface IEmployeService {
    Employe create(Employe employe);
    Employe update(Employe employe);
    Employe findById(Long id);
    List<Employe> findAll();
    void deleteById(Long id);
}
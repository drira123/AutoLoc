package tn.esprit.aichadrira4cce11.service;

import tn.esprit.aichadrira4cce11.domain.Contrat;
import java.util.List;

public interface IContratService {
    Contrat create(Contrat contrat);
    Contrat update(Contrat contrat);
    Contrat findById(Long id);
    List<Contrat> findAll();
    void deleteById(Long id);
}
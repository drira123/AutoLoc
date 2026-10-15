package tn.esprit.aichadrira4cce11.service;

import tn.esprit.aichadrira4cce11.domain.Paiement;
import java.util.List;

public interface IPaiementService {
    Paiement findById(Long id);
    List<Paiement> findAll();
}
package tn.esprit.aichadrira4cce11.service;

import tn.esprit.aichadrira4cce11.domain.Agence;

import java.util.List;

public interface IAgenceService {

    Agence create(Agence agence);

    Agence update(Agence agence);

    Agence findById(Long id);

    List<Agence> findAll();

    void deleteById(Long id);
}
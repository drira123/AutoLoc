package tn.esprit.aichadrira4cce11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aichadrira4cce11.domain.Contrat;

public interface IContratRepository extends JpaRepository<Contrat, Long> {
}
package tn.esprit.aichadrira4cce11.service;

import tn.esprit.aichadrira4cce11.domain.Maintenance;
import java.util.List;

public interface IMaintenanceService {
    Maintenance create(Maintenance maintenance);
    Maintenance update(Maintenance maintenance);
    Maintenance findById(Long id);
    List<Maintenance> findAll();
    void deleteById(Long id);
}

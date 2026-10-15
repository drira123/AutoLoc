package tn.esprit.aichadrira4cce11.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.aichadrira4cce11.domain.Paiement;
import tn.esprit.aichadrira4cce11.exception.ResourceNotFoundException;
import tn.esprit.aichadrira4cce11.repository.IPaiementRepository;
import tn.esprit.aichadrira4cce11.service.IPaiementService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final IPaiementRepository paiementRepository;

    @Override
    public Paiement findById(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Paiement introuvable : " + id));
    }

    @Override
    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }
}
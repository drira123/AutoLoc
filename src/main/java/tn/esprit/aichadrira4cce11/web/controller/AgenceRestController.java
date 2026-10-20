package tn.esprit.aichadrira4cce11.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aichadrira4cce11.domain.Agence;
import tn.esprit.aichadrira4cce11.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
public class AgenceRestController {

    private final IAgenceService agenceService;

    @PostMapping("/add")
    public Agence add(@RequestBody Agence agence) {
        return agenceService.create(agence);
    }

    @GetMapping("/get/{idAgence}")
    public Agence get(@PathVariable Long idAgence) {
        return agenceService.findById(idAgence);
    }

    @GetMapping("/all")
    public List<Agence> getAll() {
        return agenceService.findAll();
    }

    @PutMapping("/update/{idAgence}")
    public Agence update(
            @PathVariable Long idAgence,
            @RequestBody Agence agence) {
        return agenceService.update(idAgence, agence);
    }

    @DeleteMapping("/delete/{idAgence}")
    public void delete(@PathVariable Long idAgence) {
        agenceService.deleteById(idAgence);
    }
}
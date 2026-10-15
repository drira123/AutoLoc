package tn.esprit.aichadrira4cce11.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aichadrira4cce11.domain.Vehicule;
import tn.esprit.aichadrira4cce11.service.IVehiculeService;

@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeRestController {

    private final IVehiculeService vehiculeService;

    @PostMapping("/add")
    public Vehicule add(@RequestBody Vehicule vehicule) {
        return vehiculeService.create(vehicule);
    }

    @GetMapping("/get/{idVehicule}")
    public Vehicule get(@PathVariable Long idVehicule) {
        return vehiculeService.findById(idVehicule);
    }
}



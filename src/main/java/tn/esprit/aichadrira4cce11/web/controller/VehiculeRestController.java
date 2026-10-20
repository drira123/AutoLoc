package tn.esprit.aichadrira4cce11.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aichadrira4cce11.domain.Vehicule;
import tn.esprit.aichadrira4cce11.service.IVehiculeService;

import java.util.List;

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
    @GetMapping("/all")
    public List<Vehicule> getAll() { return vehiculeService.findAll();
    }
    @PutMapping("/update/{idVehicule}")
    public Vehicule update(@PathVariable Long idVehicule, @RequestBody Vehicule vehicule) {
        return vehiculeService.update(idVehicule, vehicule);
    }
    @DeleteMapping("/delete/{idVehicule}")
    public void delete(@PathVariable Long idVehicule) { vehiculeService.deleteById(idVehicule); }
}
package org.worr.gps.rest;

import org.springframework.web.bind.annotation.*;
import org.worr.gps.exceptions.UnitNotFoundExeception;
import org.worr.gps.model.Unit;
import org.worr.gps.repository.UnitRepository;

@RestController
@RequestMapping("/units")
public class UnitController {
    private final UnitRepository repository;

    public UnitController(UnitRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    Unit getUnitById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new UnitNotFoundExeception(id));
    }
}

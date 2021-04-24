package org.worr.gps.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.worr.gps.model.Gps;
import org.worr.gps.services.UnitService;

@RestController
@RequestMapping("/units")
public class UnitController {
    private final UnitService unitService;

    @Autowired
    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("/{id}")
    private Gps getUnit(@PathVariable Long id) {
        return unitService.getUnitById(id);
    }
}

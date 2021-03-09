package org.worr.gps.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.worr.gps.model.Position;
import org.worr.gps.repository.PositionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
Herman har skickat
Sen vill jag kunna hämta på datum och tid och enhetens id
 */

@RestController
public class PositionController {
    private final PositionRepository repository;

    public PositionController(PositionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Position> getPositionsBetweenTimestamps(@RequestParam("unit_id") Integer unitId, @RequestParam LocalDateTime from, @RequestParam LocalDateTime through) {
        //todo fixa get requests
        return new ArrayList<Position>();
    }


}

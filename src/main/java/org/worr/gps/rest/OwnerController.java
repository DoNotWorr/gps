package org.worr.gps.rest;

import org.springframework.web.bind.annotation.RestController;
import org.worr.gps.repository.OwnerRepository;

@RestController
public class OwnerController {
    private final OwnerRepository repository;

    public OwnerController(OwnerRepository repository) {
        this.repository = repository;
    }


}

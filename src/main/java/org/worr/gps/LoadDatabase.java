package org.worr.gps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.worr.gps.model.Owner;
import org.worr.gps.model.Position;
import org.worr.gps.model.Unit;
import org.worr.gps.repository.OwnerRepository;
import org.worr.gps.repository.PositionRepository;
import org.worr.gps.repository.UnitRepository;

import java.time.LocalDateTime;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner InitDatebase(OwnerRepository ownerRepository, UnitRepository unitRepository, PositionRepository positionRepository) {
        return args -> {
            Owner owner1 = new Owner();
            owner1.setCompanyName("Test company");
            log.info("Preloading " + ownerRepository.save(owner1));

            Unit unit1 = new Unit();
            unit1.setOwner(owner1);
            unit1.setUsageDescription("Sitter på röda traktorn");
            log.info("Preloading " + unitRepository.save(unit1));

            Position pos1 = new Position(unitRepository.findById(1).get(), "longitude 1", "latitude 1", LocalDateTime.parse("2021-03-31T15:00:00"));
            Position pos2 = new Position(unitRepository.findById(1).get(), "longitude 2", "latitude 2", LocalDateTime.parse("2021-03-31T16:00:00"));
            Position pos3 = new Position(unitRepository.findById(1).get(), "longitude 3", "latitude 3", LocalDateTime.parse("2021-04-01T15:00:00"));
            Position pos4 = new Position(unitRepository.findById(1).get(), "longitude 4", "latitude 4", LocalDateTime.parse("2021-04-02T16:00:00"));
            log.info("Preloading " + positionRepository.save(pos1));
            log.info("Preloading " + positionRepository.save(pos2));
            log.info("Preloading " + positionRepository.save(pos3));
            log.info("Preloading " + positionRepository.save(pos4));



            System.out.println(ownerRepository.findById(1).get());
            System.out.println("getUnitIds: " + ownerRepository.findById(1).get());
        };
    }
}

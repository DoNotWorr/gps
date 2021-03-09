package org.worr.gps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.worr.gps.model.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, Integer> {
}

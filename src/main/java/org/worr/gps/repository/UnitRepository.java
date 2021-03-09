package org.worr.gps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.worr.gps.model.Unit;

@Repository
public interface UnitRepository extends CrudRepository<Unit, Integer> {
}

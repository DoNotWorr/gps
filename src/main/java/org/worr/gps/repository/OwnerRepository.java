package org.worr.gps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.worr.gps.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer> {
}

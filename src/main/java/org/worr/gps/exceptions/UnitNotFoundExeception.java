package org.worr.gps.exceptions;

public class UnitNotFoundExeception extends RuntimeException {
    public UnitNotFoundExeception(Integer unitId) {
        super("Can't find unit with id " + unitId);
    }
}

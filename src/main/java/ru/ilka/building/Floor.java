package ru.ilka.building;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Collection;
import java.util.List;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Floor implements BuildingContainer<Flat> {

    int number;
    List<Flat> flats;

    @Override
    public Collection<Flat> getChildren() {
        return flats;
    }
}

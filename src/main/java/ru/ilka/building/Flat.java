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
public class Flat implements BuildingContainer<Room> {

    int number;
    List<Room> rooms;

    @Override
    public Collection<Room> getChildren() {
        return rooms;
    }
}

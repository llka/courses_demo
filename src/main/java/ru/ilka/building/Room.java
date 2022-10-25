package ru.ilka.building;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room implements BuildingContainer {

    boolean walkTrough;
    int squareSize;

    @Override
    public Collection<BuildingContainer> getChildren() {
        return null;
    }
}

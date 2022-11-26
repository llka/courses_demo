package ru.ilka.multithreading.providerconsumer.firewater;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Crystal {

    private int id;
    private CrystalColorEnum color;

    @Override
    public String toString() {
        return color.toString() + "_" + id;
    }
}

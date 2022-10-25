package ru.ilka.lambdasrseams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Pair<K> {

    List<K> list;
    Double average;
}

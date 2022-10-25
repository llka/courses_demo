package ru.ilka.lambdasrseams;

import ru.ilka.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.teeing;
import static java.util.stream.Collectors.toList;

public class StudentMappingExample {

    /**
     * Дан список студентов с полями:
     * - Имя
     * - Фамилия
     * - Номер курса в университете
     * - Список оценок за учебу
     * <p>
     * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
     * <p>
     * Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
     * <p>
     * Список студентов данного курса, но только с полями Имя и Фамилия.
     * Список должен быть отсортированы по этим двум полям
     * <p>
     * Объект с двумя полями:
     * - Отсортированный список студентов с пункта 2
     * - Средняя оценка этих студентов
     * <p>
     * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
     */
    public static void example() {
        //18 + 12 + 24 = 54
        // 54 / 8 = 6.75
        // 9 + 4 + 8 = 21 21/3 = 7 - incorrect
        List<Student> students = List.of(
            Student.builder()
                .name("A")
                .surname("AA")
                .course(1)
                .marks(List.of(10, 8)) //9
                .build(),
            Student.builder()
                .name("C")
                .surname("CC")
                .course(1)
                .marks(List.of(4, 4, 4, 4, 4, 4, 4, 4, 4, 4))//4
                .build(),
            Student.builder()
                .name("B")
                .surname("BB")
                .course(1)
                .marks(List.of(8, 8, 8))//8
                .build(),
            Student.builder()
                .name("A")
                .surname("AA")
                .course(2)
                .marks(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .build()
        );

        Map<Integer, Pair<String>> mapOfSortedStudentsAndAverageMarkByCourse3 = students.stream()
            .sorted(Comparator.comparing(Student::getName).thenComparing(Student::getSurname))
            .collect(groupingBy(Student::getCourse,
                TreeMap::new,
                teeing(
                    mapping(student -> student.getName() + " " + student.getSurname(), toList()),
                    flatMapping(student -> student.getMarks().stream(), averagingInt(Integer::intValue)),
                    Pair::new
                )));

        System.out.println(mapOfSortedStudentsAndAverageMarkByCourse3);
    }

}

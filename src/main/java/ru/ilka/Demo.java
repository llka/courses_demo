package ru.ilka;

import ru.ilka.fileutil.FileReaderUtil;
import ru.ilka.insect.Butterfly;
import ru.ilka.list.CustomLinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Demo {

    public static void main(String[] args) {

        System.out.println(FileReaderUtil.readFile("data/input.txt"));

    }

    public void writeFile() {
        String PATH = "/data";
        String directoryName = PATH + "/directory";
        String fileName = Instant.now().toString() + ".txt";

        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }

        File file = new File(directoryName + "/" + fileName);
        try (FileWriter fw = new FileWriter(file.getAbsoluteFile())) {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("test");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException("Ups", e);
        }
    }

    private static GarageAppMenuActionEnum readActionFromConsole() {
        System.out.println("Type please next action.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = reader.readLine().trim();
            if (line.matches("[0-9]+")) {
                return GarageAppMenuActionEnum.findActionByCode(Integer.parseInt(line));
            } else {
                return GarageAppMenuActionEnum.valueOf(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read next action from console.", e);
        } catch (GarageAppMenuException | IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + " Type please either action name in uppercase, or it's numeric code. ");
            return readActionFromConsole();
        }
    }


    private static void customLinkedListDemo() {
        final int SIZE = 10;
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        for (int i = 0; i < SIZE; i++) {
            customLinkedList.add(ThreadLocalRandom.current().nextInt(1, 10));
        }

        System.out.println("customLinkedList meta: ");
        System.out.println(customLinkedList);
        System.out.println("customLinkedList values: ");
        System.out.println(customLinkedList.getAllNodesValuesAsString());

        customLinkedList.removeIf(val -> val < 4);

        System.out.println("After filtering: ");
        System.out.println("customLinkedList values: ");
        System.out.println(customLinkedList.getAllNodesValuesAsString());
        System.out.println("customLinkedList meta: ");
        System.out.println(customLinkedList);
    }

    static List<Butterfly> findButterfliesByName(Collection<Butterfly> collection,
                                                 String name) {
        List<Butterfly> filtered = new ArrayList<>(collection.size());
        for (Butterfly butterfly : collection) {
            // Invoke methods on NON NULL constant or argument
            if (name.equals(butterfly.getName())) {
                filtered.add(butterfly);
            }
        }
        return filtered;
    }


    /**
     * Параметризация позволяет создавать классы, интерфейсы и методы,
     * в которых тип обрабатываемых данных задается как параметр.
     *
     * Параметризированные типы обеспечивают типобезопасность.
     *
     * instanceof
     *
     * get class
     *
     * T super
     *
     * T extends
     *
     * Параметризация List<? super Order> утверждает,
     * что параметр метода или возвращаемое значение может получить список типа Order
     * или любого из его суперклассов, в то же время разрешает добавлять туда экземпляры
     * класса Order и любых его подклассов.
     */


    /**
     * Подкласс дополняет члены суперкласса своими полями и методами.
     *
     * Если имена методов совпадают, а параметры различаются, то такое явление называ- ется перегрузкой методов
     * (статическим полиморфизмом).
     *
     * Если же совпадают имена и параметры методов, то это называется динами- ческим полиморфизмом.
     * То есть в подклассе можно объявить (переопреде- лить) метод с тем же именем, списком параметров
     * и возвращаемым значением, что и у метода суперкласса.
     *
     * Полиморфизм - способность ссылки динамически определять версию переопределенного метода в
     * зависимости от переданного ссылке объекта.
     *
     * Полиморфизм является основой для реализации механизма динамического или «позднего связывания».
     */

    /**
     * -------
     * Рекомендации при проектировании классов
     * -------
     *
     * При создании класса следует давать ему такое имя, чтобы его пользователю была понятна роль класса.
     *
     * Класс должен быть разработан так, чтобы внесение в него изменений было относительно простой задачей.
     *
     * Каждый класс должен иметь простое назначение.
     *
     * Код конструктора должен заниматься только инициализацией объекта.
     * Следует избегать вызовов из конструктора других методов, за исключением final.
     * Метод может быть переопределен в подклассе и исказить процесс иници- ализации объекта.
     *
     * Если класс отвечает за хранение информации, то функциональность работы с этой информацией должна быть базовой.
     * Манипулированием информацией через объект должны заниматься другие классы, которых может оказаться очень много.
     *
     * Использовать инкапсуляцию нестатических и неконстантных полей.
     *
     * Применять для доступа к полям классов, хранящих информацию, корректные методы
     * типа get, set, is, а также желательно реализовать методы equals(), hashCode(), clone(), toString()
     * и имплементировать интерфейсы Comparable и Serializable.
     *
     * Если разрабатываемый класс кажется сложным, следует разбить его на не- сколько простых.
     *
     * По возможности избегать слишком длинных методов. От тридцати строк — длинный метод.
     * Следует разбить метод на несколько, или даже создать для этой цели новый класс.
     *
     * Если метод используется только другими методами этого класса, следует объявлять его как private.
     *
     * Определить и распределить по разным классам функциональности, которые могут изменяться в процессе разработки,
     * от тех, которые будут постоянными.
     *
     * Хороший дизайн кода отличается высоким уровнем декомпозиции.
     *
     * Если в разных участках класса или нескольких классов востребован один и тот же фрагмент кода,
     * следует выделить его в отдельный метод.
     *
     * Избегать длинного списка аргументов. Приближаясь к числу семь,
     * список аргументов становится не воспринимаемым при чтении.
     * Возможно, следует объединить группы аргументов в новый тип данных.
     *
     * Не использовать «волшебные числа», «волшебные строки». Логичнее выне- сти их за пределы кода, например, в файл.
     */

}

package ru.ilka;

import ru.ilka.furniture.FurnitureGenerator;
import ru.ilka.furniture.Wardrobe;
import ru.ilka.insect.Butterfly;
import ru.ilka.list.CustomLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {
    private static final int SIZE = 100;

    private static final FurnitureGenerator furnitureGenerator = new FurnitureGenerator();

    public static void main(String[] args) {
        List<Wardrobe> wardrobeList = furnitureGenerator.generateWardrobesList(SIZE);

        System.out.println();

//        WardrobeHeightComparator heightComparator = new WardrobeHeightComparator();
//
//        Comparator<Wardrobe> widthComparator = new Comparator<Wardrobe>() {
//            @Override
//            public int compare(Wardrobe o1, Wardrobe o2) {
//                return o1.getWidth() - o2.getWidth();
//            }
//        };
//
//        wardrobeList.sort(heightComparator
//                .thenComparing(widthComparator)
//                .thenComparing((a, b) -> a.getDepth() - b.getDepth()));


//        showCollection(wardrobeList);

        /**
         * The purpose of the class is to provide a type-level solution for representing
         * optional values instead of null references.
         */
//        Optional<String> optional = Optional.empty();
//        System.out.println(optional.isPresent());
//
//        String s = null;
//
//        optional = Optional.ofNullable(s);
//        System.out.println(optional.isPresent());
//
//
//        s = "Hello";
//        optional = Optional.of(s);
//        System.out.println(optional.isPresent());
//
//        optional.ifPresent(val -> System.out.println(val.length()));

        /**
         * Introduced in Java 8, the Stream API is used to process collections of objects.
         *
         * A stream is a sequence of objects that supports various methods which
         * can be pipelined to produce the desired result.
         * The features of Java stream are –
         *
         * A stream is not a data structure instead it takes input from the Collections,
         * Arrays or I/O channels.
         *
         * Streams don’t change the original data structure,
         * they only provide the result as per the pipelined methods.
         *
         * Each intermediate operation is lazily executed and returns a stream as a result,
         * hence various intermediate operations can be pipelined.
         * Terminal operations mark the end of the stream and return the result.
         */

//        wardrobeList.stream()
//                .map(wardrobe -> "<" + wardrobe.getHeight() + ">" + "\n")
//                .sorted()
//                .forEach(value -> FileWriterUtil.writeToFileEnd("data/wardrobes.txt",value));
//

        Map<Integer, List<Wardrobe>> map = wardrobeList.stream()
                .collect(Collectors.groupingBy(wardrobe -> wardrobe.getHeight()));
        map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .forEach(System.out::println);


//
//        // demonstration of map method
//        List<Integer> square = number.stream().map(x -> x*x).
//                collect(Collectors.toList());
//        System.out.println(square);
//
//        // create a list of String
//        List<String> names =
//                Arrays.asList("Reflection","Collection","Stream");
//
//        // demonstration of filter method
//        List<String> result = names.stream().filter(s->s.startsWith("S")).
//                collect(Collectors.toList());
//        System.out.println(result);
//
//        // demonstration of sorted method
//        List<String> show =
//                names.stream().sorted().collect(Collectors.toList());
//        System.out.println(show);
//
//        // create a list of integers
//        List<Integer> numbers = Arrays.asList(2,3,4,5,2);
//
//        // collect method returns a set
//        Set<Integer> squareSet =
//                numbers.stream().map(x->x*x).collect(Collectors.toSet());
//        System.out.println(squareSet);
//
//        // demonstration of forEach method
//        number.stream().map(x->x*x).forEach(y->System.out.println(y));
//
//        // demonstration of reduce method
//        int even =
//                number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
//
//        System.out.println(even);


    }

    public static int reversNumber(int number) {
        int rest;
        int revers = 0;
        while (number != 0) {

            rest = number % 10;
            number = number / 10;
            revers = revers * 10 + rest;
            // System.out.println(revers);
        }

        return revers;
    }

    public static long findWordsCountOccurredOnce(String text) {
        Map<String, Long> map = Arrays.stream(text.trim().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
        return map.values().stream()
                .filter(val -> val == 1)
                .count();
    }

    private static void showCollection(Collection collection) {
        collection.stream().forEach(System.out::println);
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

    static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return (fibonacci(n - 1) + fibonacci(n - 2));
    }

    /**
     * Вопрос 11.1.
     * Дан класс:
     * class InThread implements Runnable{ public void run() {
     * } }
     * System.out.println("running...");
     * Укажите правильные варианты создания потокового объекта (1): 1) new Thread().new InThread();
     * 2) new Runnable(new InThread());
     * 3) new Thread(Intread);
     * 4) new Thread(new InThread());
     * 5) new InThread().
     *
     * Вопрос 11.2.
     * Укажите методы, определенные в классе java.lang.Thread (4):
     * 1) join()
     * 2) getPrioroty()
     * 3) wait()
     * 4) notifyAll()
     * 5) sleep()
     * 6) getName()
     *
     * Вопрос 11.3.
     * Укажите состояния потока, при вызове на которых метод isAlive() класса java.lang.Thread вернет значение true (4):
     * 1) NEW
     * 2) RUNNABLE
     * 3) BLOCKED
     * 4) WAITING
     * 5) TIMED_WAITING
     * 6) TERMINATED
     *
     * Вопрос 11.4.
     * Дан код:
     * class InThread implements Runnable{
     * public void run() {System.out.println("running..."); }
     * }
     * public class Quest {
     * public static void main(String[] args) {
     * ExecutorService exec = Executors.newFixedThreadPool(2);
     * exec.execute(new InThread());
     * exec.execute(new InThread());
     * exec.execute(new InThread());
     * exec.shutdown(); while (!exec.isTerminated()) { } }}
     */


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

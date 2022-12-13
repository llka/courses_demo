package ru.ilka;

import lombok.extern.slf4j.Slf4j;
import ru.ilka.animal.Cat;
import ru.ilka.event.Attendee;
import ru.ilka.event.Event;
import ru.ilka.event.EventRealm;
import ru.ilka.fileutil.FileReaderUtil;
import ru.ilka.furniture.FurnitureGenerator;
import ru.ilka.furniture.Wardrobe;
import ru.ilka.insect.Butterfly;
import ru.ilka.list.CustomLinkedList;
import ru.ilka.multithreading.producerconsumer.Task57Demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Slf4j
public class Demo {

    private static final int SIZE = 10_000_000;
    private static final FurnitureGenerator furnitureGenerator = new FurnitureGenerator();
    private static final Task57Demo task57Demo = new Task57Demo();
    private static ObjectGenerator<Wardrobe> wardrobeGenerator;

    public static void main(String... args) throws Exception {
        String a = "a";
        a.contains("b");
    }

    public static List<Integer> mergeSortedLists(List<Integer> a, List<Integer> b) {
        TreeSet<Integer> set = new TreeSet<>(a);
        set.addAll(b);

        return new ArrayList<>(set);
    }

    public static List<Integer> mergeSortedLists2(List<Integer> a, List<Integer> b) {
        int aIndex = 0;
        int bIndex = 0;
        List<Integer> result = new ArrayList<>(a.size() + b.size());

        if (aIndex < a.size() && bIndex < b.size()) {
            while (aIndex < a.size() && bIndex < b.size()) {
                if (a.get(aIndex) <= b.get(bIndex)) {
                    result.add(a.get(aIndex));
                    aIndex++;
                } else {
                    result.add(b.get(bIndex));
                    bIndex++;
                }
            }
        } else if (aIndex == a.size()) {
            for (int i = bIndex; i < b.size(); i++) {
                result.add(b.get(i));
            }
        } else {
            for (int i = aIndex; i < a.size(); i++) {
                result.add(a.get(i));
            }
        }
        return result;
    }

    public static void exampleExtends(List<? extends Cat> list) {
        System.out.println(list);
    }

    public static void exampleSuper(List<? super Cat> list) {
        System.out.println(list);
    }

    private static <T extends CsvObjectWithId> Map<Integer, T> readObjectsFromFile(Path path, Function<String, T> objectMapper) {
        return FileReaderUtil.readLinesFromFile(path.toString()).stream()
            .map(objectMapper)
            .collect(Collectors.toMap(T::getId, Function.identity()));
    }

    private static String randomString(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        return ThreadLocalRandom.current().ints(leftLimit, rightLimit + 1)
            .limit(length)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }

    private static List<Event> generateEvents(int size) {
        List<Event> events = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            int daysToAdd = ThreadLocalRandom.current().nextInt(1, 1000);
            Instant eventStart = Instant.now().plus(Period.ofDays(daysToAdd));
            int attendeesSize = ThreadLocalRandom.current().nextInt(5, 15);
            Event event = Event.builder()
                .realm(EventRealm.values()[ThreadLocalRandom.current().nextInt(0, EventRealm.values().length - 1)])
                .title(String.valueOf(ThreadLocalRandom.current().nextInt(1, 1000)))
                .startDate(Date.from(eventStart))
                .attendees(new ArrayList<>(attendeesSize))
                .build();
            for (int j = 0; j < attendeesSize; j++) {
                int minutesToAdd = ThreadLocalRandom.current().nextInt(1, 400);
                int minutesToLeaveTime = minutesToAdd + ThreadLocalRandom.current().nextInt(1, 400);
                Attendee attendee = Attendee.builder()
                    .name(String.valueOf(ThreadLocalRandom.current().nextInt(1, 1000)))
                    .surname(String.valueOf(ThreadLocalRandom.current().nextInt(1, 1000)))
                    .joinTime(LocalDateTime.ofInstant(eventStart.plus(minutesToAdd, ChronoUnit.MINUTES), ZoneId.of("UTC")))
                    .leaveTime(LocalDateTime.ofInstant(eventStart.plus(minutesToLeaveTime, ChronoUnit.MINUTES), ZoneId.of("UTC")))
                    .build();
                event.getAttendees().add(attendee);
            }
            events.add(event);
            System.out.println(event);
            System.out.println();
        }
        return events;
    }

    /**
     * Условие: дан текстовый файл со 100 числовыми массивами.
     * Для каждого массива посчитать произведение минимального и максимального элемента.
     * Вернуть номер массива(начиная с 1)  с максимальным результатом произведения его минимального и максимального элеметнов.
     * <p>
     * <p>
     * Формат входного файла:
     * каждая строка - отдельный массив чисел от 0 до 9999
     * первое число в строке - размер массива
     * остальные числа в строке - элементы массива
     * <p>
     * <p>
     * Пример 1:
     * дан файл
     * 3 1 2 3
     * 2 1 2
     * 5 1 2 3 4 5
     * ответ: 3, потому что у массива из 3й строки наибольший результат произведения макс и мин элементов = 1*5
     * <p>
     * Пример 2: дан файл
     * 3 3 2 3
     * 2 1 2
     * 5 1 2 3 4 5
     * ответ: 1, потому что у массива из 1й строки наибольший результат произведения макс и мин элементов = 3*3 = 9
     *
     * @return
     */
    public static int findArrayWithMaxMultiplicationOfMinAndMaxElement() {
        //Given an array arr[] and an integer K where K is smaller than size of array,
        // the task is to find the Kth smallest element in the given array.

        // max(min * max)

        String path = "/Users/ikisel/Documents/ilya/haltura/java_courses/courses_demo/src/main/resources/task1_input.txt";

        // generate input
        // arraySize K val1 val2 val3
//        for (int i = 0; i < 100; i++) {
//            Set<Integer> set = new HashSet<>();
//            int arraySize = ThreadLocalRandom.current().nextInt(10, 100);
//            //int k = ThreadLocalRandom.current().nextInt(1, arraySize - arraySize / 3);
//            while (set.size() != arraySize) {
//                int val = ThreadLocalRandom.current().nextInt(0, 9999);
//                set.add(val);
//            }
//            String line = arraySize + " " + set.stream().map(String::valueOf).collect(Collectors.joining(" ")) + "\n";
//            FileWriterUtil.getInstance().writeToFileEnd(path, line);
//        }

        List<String> inputLines = FileReaderUtil.readLinesFromFile(path);
        int[] results = new int[100];
        int resultsIdx = 0;
        for (String line : inputLines) {
            String[] inputLineSplit = line.split(" ");

            int arrSize = Integer.valueOf(inputLineSplit[0]);

            int arr[] = new int[arrSize];
            for (int i = 0; i < arrSize; i++) {
                arr[i] = Integer.valueOf(inputLineSplit[i + 1]);
            }

            int max = -1;
            int min = 999999;

            for (int i = 0; i < arr.length; i++) {
                int curr = arr[i];
                if (curr > max) {
                    max = curr;
                }
                if (curr < min) {
                    min = curr;
                }
            }

            int currArrResult = max * min;
            results[resultsIdx++] = currArrResult;
        }

        int max = 0;
        int idx = 0;
        for (int i = 0; i < results.length; i++) {
            int curr = results[i];
            if (curr > max) {
                max = curr;
                idx = i + 1;
            }
        }
        System.out.println("idx = " + idx);
        System.out.println(max);

        //idx = 53
        //14082961
        return max;
    }

    public static int reversNumber(int number) {
        int rest;
        int revers = 0;
        while (number != 0) {
            rest = number % 10;
            number = number / 10;
            revers = revers * 10 + rest;
        }
        return revers;
    }

    public static long findWordsCountOccurredOnce(String text) {
        Map<String, Long> map = Arrays.stream(text.trim().split("\\s+"))
            .collect(groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
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

    interface CsvObjectWithId {

        int getId();
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

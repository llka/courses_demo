package ru.ilka.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionDemo {
    public static void demo1() throws IllegalAccessException {
        MobilePhone phone = new MobilePhone("apple", "se", 4.5, 2);

        System.out.println("before");
        System.out.println(phone);

        Field[] fields = phone.getClass().getDeclaredFields();

        Field producer = fields[0];
        producer.setAccessible(true);
        producer.set(phone, "changedProducer");

        System.out.println("after");
        System.out.println(phone);

        System.out.println("getDeclaredFields: ");
        Arrays.stream(fields).forEach(System.out::println);

        Method[] methods = phone.getClass().getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);

        Arrays.stream(methods)
                .filter(m -> "disallowedMethod".equals(m.getName()))
                .findFirst()
                .ifPresent(method -> {
                    try {
                        method.setAccessible(true);
                        method.invoke(phone);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }
}

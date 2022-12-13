package ru.ilka;

import lombok.Data;

@Data
public class CountSort {

    public static void sort(byte[] arr) {
        byte[] count = new byte[Byte.MAX_VALUE];

        for (int i = 0; i < arr.length; i++) {
            byte value = arr[i];
            count[value]++;
        }

        int index = 0;
        for (byte value = 0; value < count.length; value++) {
            for (int j = 0; j < count[value]; j++) {
                arr[index++] = value;
            }
        }
    }
}

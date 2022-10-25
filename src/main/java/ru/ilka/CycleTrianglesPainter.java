package ru.ilka;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CycleTrianglesPainter {

    private int size = 11;
    private String fillSymbol = "1 ";
    private String emptySymbol = "  ";

    /**
     * 1 1 1 1 1 1 1 1 1 1 1
     * 0 1 1 1 1 1 1 1 1 1 0
     * 0 0 1 1 1 1 1 1 1 0 0
     * 0 0 0 1 1 1 1 1 0 0 0
     * 0 0 0 0 1 1 1 0 0 0 0
     * 0 0 0 0 0 1 0 0 0 0 0
     * 0 0 0 0 1 1 1 0 0 0 0
     * 0 0 0 1 1 1 1 1 0 0 0
     * 0 0 1 1 1 1 1 1 1 0 0
     * 0 1 1 1 1 1 1 1 1 1 0
     * 1 1 1 1 1 1 1 1 1 1 1
     */
    public void sundial() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i < size / 2 && j >= i && j < size - i) {
                    System.out.print(fillSymbol);
                } else if (i >= size / 2 && j <= i && j >= size - i - 1) {
                    System.out.print(fillSymbol);
                } else {
                    System.out.print(emptySymbol);
                }
            }
            System.out.println();
        }
    }

    /**
     * 1 0 0 0 0 0 0 0 0 0 0
     * 1 1 0 0 0 0 0 0 0 0 0
     * 1 1 1 0 0 0 0 0 0 0 0
     * 1 1 1 1 0 0 0 0 0 0 0
     * 1 1 1 1 1 0 0 0 0 0 0
     * 1 1 1 1 1 1 0 0 0 0 0
     * 1 1 1 1 1 1 1 0 0 0 0
     * 1 1 1 1 1 1 1 1 0 0 0
     * 1 1 1 1 1 1 1 1 1 0 0
     * 1 1 1 1 1 1 1 1 1 1 0
     * 1 1 1 1 1 1 1 1 1 1 1
     */
    public void leftBottomTriangle() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i >= j) {
                    System.out.print(fillSymbol);
                } else {
                    System.out.print(emptySymbol);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 1 1 1 1 1 1 1 1 1 1 1
     * 0 1 1 1 1 1 1 1 1 1 1
     * 0 0 1 1 1 1 1 1 1 1 1
     * 0 0 0 1 1 1 1 1 1 1 1
     * 0 0 0 0 1 1 1 1 1 1 1
     * 0 0 0 0 0 1 1 1 1 1 1
     * 0 0 0 0 0 0 1 1 1 1 1
     * 0 0 0 0 0 0 0 1 1 1 1
     * 0 0 0 0 0 0 0 0 1 1 1
     * 0 0 0 0 0 0 0 0 0 1 1
     * 0 0 0 0 0 0 0 0 0 0 1
     */
    public void rightTopTriangle() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i >= j) {
                    System.out.print(fillSymbol);
                } else {
                    System.out.print(emptySymbol);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 1
     * 0 0 0 0 0 0 0 0 0 1 1
     * 0 0 0 0 0 0 0 0 1 1 1
     * 0 0 0 0 0 0 0 1 1 1 1
     * 0 0 0 0 0 0 1 1 1 1 1
     * 0 0 0 0 0 1 1 1 1 1 1
     * 0 0 0 0 1 1 1 1 1 1 1
     * 0 0 0 1 1 1 1 1 1 1 1
     * 0 0 1 1 1 1 1 1 1 1 1
     * 0 1 1 1 1 1 1 1 1 1 1
     */
    public void rightBottomTriangle() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j >= size - i) {
                    System.out.print(fillSymbol);
                } else {
                    System.out.print(emptySymbol);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 1 1 1 1 1 1 1 1 1 1 1
     * 0 1 1 1 1 1 1 1 1 1 0
     * 0 0 1 1 1 1 1 1 1 0 0
     * 0 0 0 1 1 1 1 1 0 0 0
     * 0 0 0 0 1 1 1 0 0 0 0
     * 0 0 0 0 0 1 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     */
    public void upperCenterTriangle() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i <= j && i <= size / 2 && j < size - i) {
                    System.out.print(fillSymbol);
                } else {
                    System.out.print(emptySymbol);
                }
            }
            System.out.println();
        }
    }

    /**
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 1 0 0 0 0 0
     * 0 0 0 0 1 1 1 0 0 0 0
     * 0 0 0 1 1 1 1 1 0 0 0
     * 0 0 1 1 1 1 1 1 1 0 0
     * 0 1 1 1 1 1 1 1 1 1 0
     * 1 1 1 1 1 1 1 1 1 1 1
     */
    public void bottomCenterTriangle() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i >= j && i >= size / 2 && j >= size - i - 1) {
                    System.out.print(fillSymbol);
                } else {
                    System.out.print(emptySymbol);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}

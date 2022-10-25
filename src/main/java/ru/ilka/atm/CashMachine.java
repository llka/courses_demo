package ru.ilka.atm;

import java.util.Map;

public class CashMachine implements ATM {

    private final Map<Integer, Integer> money;

    public CashMachine(int twenties, int fifties, int hundreds) {
        money = Map.of(
            20, twenties,
            50, fifties,
            100, hundreds);
    }

    public Map<Integer, Integer> getMoney() {
        return money;
    }

    @Override
    public WithdrawalResult withdrawCash(int amount) {
        for (int i = 0; i < money.get(100); i++) {
            for (int j = 0; j < money.get(50); j++) {
                for (int k = 0; k < money.get(20); k++) {
                    int sum = 100 * i + 50 * j + 20 * k;
                    System.out.println(sum);
                    if (sum == amount) {
                        System.out.println();
                        return WithdrawalResult.builder()
                            .isSuccessful(true)
                            .moneyMap(Map.of(100, i,
                                50, j,
                                20, k))
                            .build();
                    }
                    if (sum > amount) {
                        break;
                    }
                }
            }
        }

        return WithdrawalResult.builder()
            .isSuccessful(false)
            .build();
    }

}

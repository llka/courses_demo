package ru.ilka.atm;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class CashMachineGeneralCase implements ATM {

    private final Map<Integer, Integer> money;

    public CashMachineGeneralCase(final Map<Integer, Integer> money) {
        this.money = money;
    }

    public Map<Integer, Integer> getMoney() {
        return money;
    }

    @Override
    public WithdrawalResult withdrawCash(int amount) {

        int maxAmount = money.entrySet().stream()
            .map(entry -> entry.getKey() * entry.getValue())
            .reduce(0, Integer::sum);
        log.info("Max available amount: {}", maxAmount);

        if (amount > maxAmount) {
            return WithdrawalResult.builder()
                .isSuccessful(false)
                .build();
        }

        int[] banknotes = money.keySet().stream().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int[] count = new int[banknotes.length];
        int lvlIdx = 0;

        while (lvlIdx <= banknotes.length - 1) {
            int currentSum = 0;
            for (int i = 0; i < banknotes.length; i++) {
                currentSum += banknotes[i] * count[i];
            }
            log.debug("current sum: {}", currentSum);

            if (currentSum == amount) {
                Map<Integer, Integer> usedBanknotes = new HashMap<>();
                for (int i = 0; i < banknotes.length; i++) {
                    usedBanknotes.put(banknotes[i], count[i]);
                }
                return WithdrawalResult.builder()
                    .isSuccessful(true)
                    .moneyMap(usedBanknotes)
                    .build();
            }

            if (lvlIdx == banknotes.length - 1 && count[lvlIdx] == money.get(banknotes[lvlIdx])) {
                return WithdrawalResult.builder()
                    .isSuccessful(false)
                    .build();
            }

            int previousLvl = 0;
            if (count[lvlIdx] < money.get(banknotes[lvlIdx])) {
                int lastNotFullLvl = 0;
                for (int i = 0; i <= lvlIdx; i++) {
                    if (count[i] < money.get(banknotes[i])) {
                        lastNotFullLvl = i;
                        break;
                    }
                }
                count[lastNotFullLvl]++;
                if (previousLvl < lastNotFullLvl) {
                    previousLvl = lastNotFullLvl;

                    for (int i = 0; i < previousLvl; i++) {
                        count[i] = 0;
                    }
                }
            } else {
                for (int i = 0; i <= lvlIdx; i++) {
                    count[i] = 0;
                }
                lvlIdx++;
                count[lvlIdx]++;
            }
        }

        return WithdrawalResult.builder()
            .isSuccessful(false)
            .build();
    }

    /**
     * 20 50  100
     * 20 40 90  190
     * 50 90 180 370
     * 100 190 370
     */
//    public WithdrawalResult dp(int amount) {
//
//        long[][][] dp
//
//        return WithdrawalResult.builder()
//            .isSuccessful(false)
//            .build();
//    }

}

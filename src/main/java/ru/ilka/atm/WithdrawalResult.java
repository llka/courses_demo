package ru.ilka.atm;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WithdrawalResult {

    boolean isSuccessful;
    Map<Integer, Integer> moneyMap;
}

package com.metro.one.utils.enums;

import lombok.Getter;

@Getter
public enum TypeRechargeOfDays {

    TEN_DAYS(10),
    TWENTY_DAYS(20),
    THIRTY_DAYS(30);

    private final int value;

    TypeRechargeOfDays(int value) {
        this.value = value;
    }

    public static TypeRechargeOfDays fromValue(int value){
        for (TypeRechargeOfDays typeRechargeOfDays : TypeRechargeOfDays.values()) {
            if (typeRechargeOfDays.value == value) {
                return typeRechargeOfDays;
            }
        }
        throw new IllegalArgumentException("null value: " + value);
    }
}

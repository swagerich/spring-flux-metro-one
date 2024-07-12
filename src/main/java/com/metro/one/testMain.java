package com.metro.one;


import com.metro.one.utils.enums.TypeRechargeOfDays;

import java.util.Arrays;
import java.util.List;

public class testMain {
    public static void main(String[] args) {

        List<TypeRechargeOfDays> recharges = Arrays.stream(TypeRechargeOfDays.values()).toList();
        recharges.forEach(x -> System.out.println(x.getValue()));

    }

}

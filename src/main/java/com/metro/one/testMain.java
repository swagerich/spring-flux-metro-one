package com.metro.one;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class testMain {
    public static void main(String[] args) {

        var time = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
//        System.out.println(formatter.format(time));
        System.out.println(time);
        System.out.println(toFormat(time));
    }
    public static String toFormat(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(formatter.format(localDate)).toString();

    }
}

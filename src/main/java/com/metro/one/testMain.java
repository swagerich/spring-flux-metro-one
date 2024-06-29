package com.metro.one;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class testMain {
    public static void main(String[] args) {

        var time = LocalDate.now();

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
//        System.out.println(formatter.format(time));
        String string = time.toString();
        System.out.println(string);
        System.out.println(toFormat(string));
    }
    public static String toFormat(String localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse = LocalDate.parse(localDate, formatter);

        return String.join("/", String.valueOf(parse.getDayOfMonth()), String.valueOf(parse.getYear()));

    }
}

package com.metro.one.utils.dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dates {

    public static String toFormat(LocalDate localDate){
        final String patternYearMonth = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternYearMonth);
        return formatter.format(localDate);
    }

    public static String toFormatToYearMonth(String localDate){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parse = LocalDate.parse(localDate, formatter);
            return String.join("/", String.valueOf(parse.getDayOfMonth()), String.valueOf(parse.getYear()));

    }
}

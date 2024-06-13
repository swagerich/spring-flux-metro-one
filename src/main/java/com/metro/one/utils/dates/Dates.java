package com.metro.one.utils.dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dates {

    public static String toFormat(LocalDate localDate){
        final String patternYearMonth = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternYearMonth);
        return formatter.format(localDate);
    }
}

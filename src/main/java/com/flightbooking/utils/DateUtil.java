package com.flightbooking.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String getFutureDate(int monthsAfter) {
        LocalDate futureDate = LocalDate.now().plusMonths(monthsAfter);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM");
        return futureDate.format(formatter);
    }
}

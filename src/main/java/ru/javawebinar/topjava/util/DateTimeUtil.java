package ru.javawebinar.topjava.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final LocalDateTime MIN_DATE = LocalDateTime.of(1, 0,0,0,0);
    private static final LocalDateTime MAX_DATE = LocalDateTime.of(3000,0,0,0,0);

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }

    public static LocalDateTime getStartInclusive(LocalDate startDate) {
        return startDate != null ? startDate.atStartOfDay() : MIN_DATE;
    }


    public static LocalDateTime getEndInclusive(LocalDate endDate) {
        return endDate != null ? endDate.plus(1, ChronoUnit.DAYS).atStartOfDay() : MAX_DATE;
    }
}


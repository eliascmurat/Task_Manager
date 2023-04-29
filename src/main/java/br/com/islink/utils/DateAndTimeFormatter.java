package br.com.islink.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTimeFormatter {

    private static final String formatOfPattern = "dd/MM/yyyy HH:mm";

    public static String format(LocalDateTime dateAndTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatOfPattern);
        return dateAndTime.format(dateTimeFormatter);
    }

}

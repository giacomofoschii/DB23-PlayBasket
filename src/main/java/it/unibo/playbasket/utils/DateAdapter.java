package it.unibo.playbasket.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Optional;

public final class DateAdapter {

    public static java.util.Date sqlDateToDate(final java.sql.Timestamp sqlDate) {
        return sqlDate == null ? null : new java.util.Date(sqlDate.getTime());
    }

    public static java.sql.Timestamp dateToSqlDate(final java.util.Date date) {
        return date == null ? null : new java.sql.Timestamp(date.getTime());
    }

    public static Optional<java.util.Date> buildDate(final String dateString) {
        try {
            final String dateFormatString = "yyyy-MM-dd HH:mm:ss";
            final java.util.Date date = new SimpleDateFormat(dateFormatString, Locale.ITALIAN).parse(dateString);
            return Optional.of(date);
        } catch (final ParseException e) {
            return Optional.empty();
        }
    }

    public static Optional<java.util.Date> buildDate(final int day, final int month, final int year, final int hour, final int minute, final int second) {
        final String dateString = day + "-" + month + "-" + year + " " + hour + ":" + minute + ":" + second;
        return buildDate(dateString);
    }
}

package com.epam.java8.tasks.impl;

import com.epam.java8.tasks.HomeTask;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class HomeTaskNineImpl implements HomeTask {


/*
    // Some of the utility Methods of Local Date //
   LocalDate localDate = LocalDate.now();
   LocalDate tomorrow = LocalDate.now().plusDays(1);
   LocalDate yesterday = LocalDate.now().minusDays(1);
   LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
   DayOfWeek sunday               = LocalDate.parse("2016-06-12").getDayOfWeek();
   int       twelve               = LocalDate.parse("2016-06-12").getDayOfMonth();
   boolean leapYear = LocalDate.now().isLeapYear();
   boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
   boolean        isAfter         = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));
   LocalDateTime beginningOfDay  = LocalDate.parse("2016-06-12").atStartOfDay();
   LocalDate     firstDayOfMonth = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());


    // Some of the utility Methods of Local Time //
    LocalTime now = LocalTime.now();
    LocalTime sixThirty = LocalTime.parse("06:30");
    LocalTime six_Thirty = LocalTime.of(6, 30);
    LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
    int six = LocalTime.parse("06:30").getHour();
    boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
    LocalTime maxTime = LocalTime.MAX;


    // Some of the Utility Methods of LocalDateTime //
    LocalDateTime localDateTime = LocalDateTime.now();
    LocalDateTime localDateTime1 = LocalDateTime.of(2015, Month.FEBRUARY, 20, 30, 06);
    LocalDateTime localDateTime2 = LocalDateTime.parse("2015-02-20T06:30:00");
    LocalDateTime plusDays = LocalDateTime.now().plusDays(1);
    LocalDateTime minusHours = LocalDateTime.now().minusHours(4);
    Month         months     = LocalDateTime.now().getMonth();

    // Some of the Utility Methods Of ZonedDateTimeAPI //
    ZoneId      zoneId     = ZoneId.of("Europe/Paris");
    Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
    ZonedDateTime zonedDateTime1 = ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");

    // Some of the utility Methods of Period //
    LocalDate initialDate = LocalDate.parse("2007-05-10");
    LocalDate finalDate = initialDate.plus(Period.ofDays(5));
    int five = Period.between(initialDate, finalDate).getDays();
    long five1 = ChronoUnit.DAYS.between(initialDate, finalDate);

    // Some of the Utility Methods of the Duration //
    LocalTime initialTime = LocalTime.of(6, 30, 0);
    LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
    long thirty = Duration.between(initialTime, finalTime).getSeconds();
    long thirty1 = ChronoUnit.SECONDS.between(initialTime, finalTime);
*/

    BiPredicate<LocalDate, LocalDate> isPreviousDay = ((localDate1, localDate2) -> Period.between(localDate1,localDate2).getDays()==1);
    Predicate<LocalDate> isYesterday = (localDate1 -> LocalDate.now().minusDays(1).equals(localDate1));

    Supplier<LocalDate> nextThrusDay = (() -> LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.THURSDAY)));
    Supplier<ZonedDateTime> currentDateTime = (() -> ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/New_York")));

    Function<LocalDate, Period> getAge = (localDate1 -> Period.between(localDate1, LocalDate.now()));


    public boolean isYesterDay(LocalDate date) {
        return isYesterday.test(date);
    }

    public LocalDate nextThrusday(LocalDate date) {
        return nextThrusDay.get();
    }

    public ZonedDateTime getCurrentTime() {
        return currentDateTime.get();
    }

    public int getAge(LocalDate date) {
        return getAge.apply(date).getYears();
    }


    @Override
    public void driver() {

    }
}

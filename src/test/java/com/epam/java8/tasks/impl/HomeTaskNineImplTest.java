package com.epam.java8.tasks.impl;

import com.epam.java8.utils.DataExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.junit.jupiter.api.Assertions.*;

class HomeTaskNineImplTest {

    DataExtractor dataExtractor;
    HomeTaskNineImpl homeTaskNine;

    @BeforeEach
    void beforeAll() {
        dataExtractor = new DataExtractor();
        homeTaskNine = new HomeTaskNineImpl();
    }

    @Test
    void isYesterDay() {
        boolean yesterDay = homeTaskNine.isYesterDay(LocalDate.of(2021, 03, 5));
        assertTrue(yesterDay);
    }

    @Test
    void nextThrusday() {
        LocalDate localDate = homeTaskNine.nextThrusday(LocalDate.now());
        assertTrue(localDate.getDayOfWeek().equals(DayOfWeek.THURSDAY));
    }

    @Test
    void getCurrentTime() {
        ZonedDateTime currentTime = homeTaskNine.getCurrentTime();
        assertTrue(currentTime.getZone().equals(ZoneId.of("America/New_York")));
    }

    @Test
    void getAge() {
        int age = homeTaskNine.getAge(LocalDate.parse("1996-10-06"));
        assertTrue(age==24);
    }
}
package learn.katas.corejava.ocpkata.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import static org.junit.jupiter.api.Assertions.*;

public class FormatDateTimeTest {
    @Test
    public void calculateDayOfTheWeekNextYear() {
        LocalDate now = null;
        // todo: Calculate which day of the week this date would be next year
        DayOfWeek day = null;
        assertNotNull(day);
    }

    @Test
    public void durationBetweenCurrentTimeAndFutureTime() {
        LocalTime teaTime = null;
        // todo: Calculate duration between the current time and tea time
        Duration timeGap = null;
        assertNotNull(timeGap);
    }

    @Test
    void calculateTomorrowTeaTime() {
        LocalTime teaTime = null;
        // todo: create LocalDateTime for tomorrow tea time
        LocalDateTime tomorrowTeaTime = null;
        System.out.println("tomorrowTeaTime = " + tomorrowTeaTime);
        assertNotNull(tomorrowTeaTime);
        assertTrue(tomorrowTeaTime.isAfter(LocalDateTime.now()));
    }

    @Test
    void findZonedDateTimesForTheSameInstant() {
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
        // todo: declare zone ids for London and Katmandu
        ZoneId london = null;
        ZoneId katmandu = null;
        // todo: init London time and find that same time in Katmandu
        ZonedDateTime londonTime = null;
        ZonedDateTime katmanduTime = null;
        assertNotNull(londonTime);
        assertNotNull(katmanduTime);
        assertEquals(londonTime.toInstant(), katmanduTime.toInstant());
    }

    @Test
    void usePatternToFormatZonedDateAndTimeValue() {
        // todo: declare a date time pattern for formatting zoned date time
        String datePattern = null;
        DateTimeFormatter formatter = null;
        TemporalAccessor someTimeInLondon = ZonedDateTime.of(2021, 3, 15,
                19, 56, 30, 0, ZoneId.of("Europe/London"));
        String timeFormatted = null;
        assertNotNull(timeFormatted);
        final String expected = "Monday, 15 of March 2021 at 19:56 GMT";
        assertEquals(expected, timeFormatted);
    }
}

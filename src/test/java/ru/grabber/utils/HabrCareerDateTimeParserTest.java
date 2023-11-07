package ru.grabber.utils;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.*;

class HabrCareerDateTimeParserTest {
    @Test
    void check() {
        HabrCareerDateTimeParser hcdtp = new HabrCareerDateTimeParser();
        String dt = "2023-02-11T10:53:40+03:00";
        LocalDateTime expected = ZonedDateTime.parse(dt).toLocalDateTime();
        LocalDateTime actual = hcdtp.parse(dt);
        assertThat(actual).isEqualTo(expected);
    }
}
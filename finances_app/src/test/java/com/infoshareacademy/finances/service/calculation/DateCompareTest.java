package com.infoshareacademy.finances.service.calculation;

import org.junit.Test;

import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;

public class DateCompareTest {

    @Test
    public void should_return_negative_int_when_past_date() throws Exception {
        ZonedDateTime past = ZonedDateTime.now().minusDays(2);
        DateCompare dateCompare = new DateCompare();

        assertEquals(-1, dateCompare.timeOut(past) );

    }

    @Test
    public void should_return_positive_int_when_future_date() throws Exception {
        ZonedDateTime past = ZonedDateTime.now().plusDays(5);
        DateCompare dateCompare = new DateCompare();

        assertEquals(1, dateCompare.timeOut(past) );

    }

}
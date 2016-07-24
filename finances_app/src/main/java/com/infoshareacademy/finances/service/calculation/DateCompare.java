package com.infoshareacademy.finances.service.calculation;

import javax.ejb.Stateless;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

@Stateless
public class DateCompare {

    public DateCompare() {
    }

    public int timeOut(ZonedDateTime actionTime) {
        Comparator<ZonedDateTime> comparator = Comparator.comparing(zonedDateTime -> zonedDateTime.truncatedTo(ChronoUnit.MINUTES));
        return comparator.compare(actionTime, ZonedDateTime.now());
    }


}

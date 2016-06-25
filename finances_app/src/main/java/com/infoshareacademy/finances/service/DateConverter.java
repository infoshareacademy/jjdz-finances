package com.infoshareacademy.finances.service;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Converter(autoApply = true)
public class DateConverter implements AttributeConverter<ZonedDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(ZonedDateTime zonedDateTime) {
        return Date.from(zonedDateTime.toInstant());
    }

    @Override
    public ZonedDateTime convertToEntityAttribute(Date date) {
        return ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}

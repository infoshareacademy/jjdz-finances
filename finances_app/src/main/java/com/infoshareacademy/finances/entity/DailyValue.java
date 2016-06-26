package com.infoshareacademy.finances.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class DailyValue {

    private LocalDate date;
    private BigDecimal closeValue;

    public DailyValue(LocalDate date, BigDecimal closeValue) {
        this.date = date;
        this.closeValue = closeValue;
    }

	public DailyValue() {
	}

	public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getCloseValue() {
        return closeValue;
    }

    public void setCloseValue(BigDecimal closeValue) {
        this.closeValue = closeValue;
    }

    @Override
    public String toString() {
        return date + " - " + closeValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DailyValue that = (DailyValue) o;

        if (getDate() != null ? !getDate().equals(that.getDate()) : that.getDate() != null) return false;
        return getCloseValue() != null ? getCloseValue().equals(that.getCloseValue()) : that.getCloseValue() == null;

    }

    @Override
    public int hashCode() {
        int result = getDate() != null ? getDate().hashCode() : 0;
        result = 31 * result + (getCloseValue() != null ? getCloseValue().hashCode() : 0);
        return result;
    }
}

package com.infoshareacademy.finances.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class MainFormInputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private MainFormInput mainFormInput;

    @Temporal(TemporalType.DATE)
    private Date date;

    public MainFormInputEntity() {
    }

    private MainFormInputEntity(Builder builder) {
        this.mainFormInput = builder.mainFormInput;
        this.date = builder.date;
    }

    public static Builder fromMainFormInput(MainFormInput mainFormInput) {
        return new Builder().withMainFormInput(mainFormInput);
    }

    public static class Builder {
        private MainFormInput mainFormInput;
        private Date date;

        public Builder withMainFormInput(MainFormInput mainFormInput) {
            this.mainFormInput = mainFormInput;
            return this;
        }

        public Builder withCurrentDate() {
            this.date = Calendar.getInstance().getTime();
            return this;
        }

        public Builder withDate(Date date) {
            this.date = date;
            return this;
        }

        public MainFormInputEntity build() {
            return new MainFormInputEntity(this);
        }

    }
}

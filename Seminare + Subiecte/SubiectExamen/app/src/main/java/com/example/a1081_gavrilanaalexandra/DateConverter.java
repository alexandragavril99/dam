package com.example.a1081_gavrilanaalexandra;


import android.widget.DatePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateConverter {

    private static final String FORMAT_DATE = "dd/MM/yyyy";
    private final SimpleDateFormat formatter;

    public DateConverter() {
        formatter = new SimpleDateFormat(FORMAT_DATE, Locale.US);
    }

    public Date fromString(String value) {
        try {
            //metoda parse este folosita pentru conversia String to Date
            return formatter.parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    public String toString(Date value) {
        if (value == null) {
            return null;
        }
        //metoda format este utilizata pentru conversia Date to String
        return formatter.format(value);
    }

    public static Date getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

}

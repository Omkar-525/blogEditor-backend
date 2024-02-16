package com.omkar.blogeditor.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class AppUtil {
    public String getMothYear(){
        YearMonth currentYearMonth = YearMonth.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yyyy");
        String formattedDate = currentYearMonth.format(formatter).toUpperCase();
        return formattedDate;
    }
     public String getDateMonthYear(){
         LocalDate currentDate = LocalDate.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
         String formattedDate = currentDate.format(formatter).toUpperCase();
         return formattedDate;
    }

    public String getMonth(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM");
        String formattedDate = currentDate.format(formatter).toUpperCase();
        return formattedDate;
    }
}

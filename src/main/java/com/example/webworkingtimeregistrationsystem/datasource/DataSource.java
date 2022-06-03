package com.example.webworkingtimeregistrationsystem.datasource;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public final class DataSource {
    public static String url = "jdbc:sqlite:src/database/project.db";

    private DataSource() {

    }

    // Prepere String value to insert into query - if it's null we dont use '' in insert
    public static String formatStringToInsert(String input){
        if (input == null)
            return null;
        return  "'" + input + "'";
    }


    public static long formatDateToInsert(Date date){
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return date.getTime();
    }

    public static long formatDateToInsert(String dateStr) {
        try {
            Date date;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.parse(dateStr);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static Date dateFromStrDate(String strDate) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

}

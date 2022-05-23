package com.example.webworkingtimeregistrationsystem.datasource;

import org.jetbrains.annotations.NotNull;

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

    @NotNull
    public static String formatDateToInsert(Date input){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(input);
    }

}

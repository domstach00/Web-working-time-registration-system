package com.example.webworkingtimeregistrationsystem.datasource;

public final class DataSource {
    public static String url = "jdbc:sqlite:src/database/project.db";

    private DataSource() {

    }

    // Prepere String value to insert into query - if it's null we dont use '' in insert
    public static String formatToInsert(String input){
        if (input == null)
            return null;
        return  "'" + input + "'";
    }
}

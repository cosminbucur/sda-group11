package com.bucur.cohesion.high;

public class DemoHighCohesion {

    public static void main(String[] args) {

        // example of high cohesion: each class has a specific role

        InternetDownloader internetDownloader = new InternetDownloader();
        DataParser dataParser = new DataParser();
        DatabaseSaver databaseSaver = new DatabaseSaver();

        internetDownloader.downloadFromInternet();
        dataParser.parseData();
        databaseSaver.storeIntoDatabase();
    }

}

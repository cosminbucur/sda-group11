package com.bucur.cohesion.low;

// example of low cohesion: this class is doing 3 unrelated things

public class DownloadAndStore {

    public void doEverything() {
        downloadFromInternet();
        parseData();
        storeIntoDatabase();
    }

    private void downloadFromInternet() {
        System.out.println("downloading...");
    }

    private void parseData() {
        System.out.println("reading downloaded file");
    }

    private void storeIntoDatabase() {
        System.out.println("saving data in the db");
    }
}

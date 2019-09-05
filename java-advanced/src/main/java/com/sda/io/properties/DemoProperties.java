package com.sda.io.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DemoProperties {

    public static void main(String[] args) throws IOException {
        String appConfigPath = "C:\\dev\\sda\\group11\\java-advanced\\src\\main\\resources\\app.properties";

        Properties properties = new Properties();
        properties.load(new FileInputStream(appConfigPath));

        System.out.println("version of the app = " + properties.getProperty("version"));
    }
}

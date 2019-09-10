package com.bucur.io.properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.File;

public class DemoReadYaml {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            User user = mapper.readValue(
                    new File("C:\\dev\\sda\\sda\\java-advanced\\src\\main\\resources\\user.yml"),
                    User.class);
            System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

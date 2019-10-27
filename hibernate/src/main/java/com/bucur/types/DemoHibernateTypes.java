package com.bucur.types;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DemoHibernateTypes {

    public static void main(String[] args) {
        Player player = createPlayer(createAddress());

        PlayerDao playerDao = new PlayerDao();
        playerDao.create(player);
    }

    private static Player createPlayer(Address address) {
        Player player = new Player();
        player.setUsername("jonsnow");
        player.setBirthDate(LocalDate.of(1980, 7, 21));
        player.setRegistrationTime(LocalDateTime.now());
        player.setAge(21);
        player.setStatus(Status.ACTIVE);
        player.setAddress(address);
        return player;
    }

    private static Address createAddress() {
        Address address = new Address();
        address.setAddressLine1("str Unirii 10");
        address.setAddressLine2("bl 1, ap 20");
        address.setCity("Bucharest");
        address.setCounty("Bucharest");
        address.setCountry("Romania");
        return address;
    }
}

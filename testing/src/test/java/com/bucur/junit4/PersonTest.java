package com.bucur.junit4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
Create Person Class. It should have one method:
    a) boolean isTeenager() -> returns True if Person is older than 10 and younger than 20
*/
public class PersonTest {

    @Test
    public void givenPersonWithAge10_whenIsTeenager_thenReturnTrue() {
        // given
        Person person = new Person();
        person.setAge(10);

        // when
        boolean actualResult = person.isTeenager();

        // then
//        assertEquals(true, actualResult);
        assertTrue(actualResult);
    }

    @Test
    public void givenPersonWithAge20_whenIsTeenager_thenReturnFalse() {
        // given
        Person person = new Person();
        person.setAge(20);
        boolean expectedResult = false;

        // when
        boolean actualResult = person.isTeenager();

        // then
        assertEquals(expectedResult, actualResult);
    }
}

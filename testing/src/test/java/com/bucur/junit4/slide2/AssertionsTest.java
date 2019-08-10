package com.bucur.junit4.slide2;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class AssertionsTest {

    @Test
    public void assertionTest() {
        int[] array1 = {1, 2};
        int[] array2 = {1, 2};
        String nullString = null;
        String one = "text";
        String two = "text";

        assertEquals(64, 2 * 32);
        assertNotEquals("values are not equal", 1, 2);
        assertTrue(true);
        assertFalse(false);
        assertArrayEquals(array1, array2);
        assertArrayEquals(array1, array2);
        assertNull(nullString);
        assertSame(one, two);
    }
}

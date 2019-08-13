package com.bucur.junit4;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void fluentAssertions() {
        String[] stringArray = {"abc", "cde", "efg"};
        assertThat(stringArray)
                .hasSize(3)
                .contains("abc")
                .doesNotContain("x");

        String text = "abc";
        assertThat(text).isEqualTo("abc");
        assertThat(10 > 5).isTrue();
    }
}

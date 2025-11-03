package com.demo.springboothelloworld;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestTest {

    @Test
    void shouldMatchSize(){
      List<Integer> list =  Arrays.asList(1,2,3);
      assertThat(list, Matchers.hasSize(3));
        assertThat(list, Matchers.hasItems(1,2,3));
        assertThat(list, Matchers.everyItem(Matchers.greaterThanOrEqualTo(1)));

        assertThat("",Matchers.emptyOrNullString());
        assertThat("",Matchers.blankOrNullString());
        assertThat("abcde", Matchers.endsWith("cde"));
    }
}

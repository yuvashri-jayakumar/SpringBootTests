package com.demo.springboothelloworld;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class JAssertTest {

    @Test
    void shouldMatchSize(){
        List<Integer> list =  Arrays.asList(10,20,30);
//        assertThat(list, Matchers.hasSize(3));
//        assertThat(list, Matchers.hasItems(1,2,3));
//        assertThat(list, Matchers.everyItem(Matchers.greaterThanOrEqualTo(1)));

        assertThat(list).hasSize(3)
                .contains(20)
                .containsOnly(10,20,30)
                .allMatch(x -> x >= 10)
                .allMatch(x -> x < 100)
                .noneMatch(x -> x < 0);
//
//        assertThat("",Matchers.emptyOrNullString());
//        assertThat("",Matchers.blankOrNullString());
//        assertThat("abcde", Matchers.endsWith("cde"));
        String str = "abcde";
        assertThat(str).isNotEmpty().isNotBlank()
                .endsWith("cde");
    }
}

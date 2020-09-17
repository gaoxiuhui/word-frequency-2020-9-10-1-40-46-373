package com.thoughtworks.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WordFrequencyTest {

    @Test
    public void given_stopword_in_strings_when_countWordNum_then_count_corrent() {
        //given
        List<String> stopWords=new ArrayList<>();
        WordFrequency wordFrequency=new WordFrequency();
        String stings="My home is very nice My sister is very nice";
        stopWords.add("is");
        //when
        Map<String,Integer> countWordFrequencyMap=wordFrequency.countWordFrequency(stings,stopWords);
        //then
        assertEquals(countWordFrequencyMap.get("my").intValue(),2);
    }
}

package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

class StrUrlTest {

    @Test
    void getUrlString() {
     StrUrl strUrl = new StrUrl("Moscow");
     assertTrue(strUrl.getUrlString().contains("Moscow"));
    }
}